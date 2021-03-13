package com.person.cn.demotestone.classloader;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author ym.y
 * @description 自定义类加载器
 * @package com.person.cn.demotestone.classloader
 * @updateUser
 * @date 10:562020/12/2
 */
@Slf4j
public class CompileClassLoader extends ClassLoader {

    /**
     * 读取文件内容
     *
     * @param fileName
     * @return
     */
    private byte[] getBytes(String fileName) {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try {
            FileInputStream fin = new FileInputStream(file);
            //一次性读取Class文件的全部内容
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("无法读取全部的文件：" + r + " != " + len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return raw;
    }

    /**
     * @description 编译指定java文件
     * @author ym.y
     * @updateUser
     * @date 11:25 2020/12/2
     */
    private boolean compile(String javaFile) {
        log.info("CompileClassLoader：正在编译" + javaFile + "...");
        //调用系统的javac命令
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("javac " + javaFile);
            //其他线程都等待这个线程完成
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取javac线程的退出值
        int ret = process.exitValue();
        //返回编译是否成功
        return ret == 0;
    }

    /**
     * @description 根据指定类名查找类
     * @author ym.y
     * @updateUser
     * @date 11:35 2020/12/2
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //将包路径下的(.)替换成(/)
        String fileStub = name.replace(".", "/");
        String javaFileName = fileStub + ".java";
        String classFileName = fileStub + ".class";
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);
        try {
            //如果java源文件存在，并且字节码文件不存在，或者源文件的最后修改时间大于字节码的最后修改时间，则需要重新编译
            if (javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()) {
                //编译失败,或者class文件不存在
                if (!compile(javaFileName) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (classFile.exists()) {
            try {
                //将Class文件的二进制数据读入数组
                byte[] raw = getBytes(classFileName);
                //调用ClassLoader的defineClass方法将二进制数据转换成Class对象
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (clazz == null) {
            //说明加载失败
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        //如果运行该程序没有参数，即没有目标
        if(args.length < 1){
            log.info("缺少目标类，请按如下格运行Java源文件");
            System.out.println("java CompileClassLoader ClassName");
        }
        //第一个参数是需要运行的类
       String  progClass =  args[0];
        //剩下参数为运行目标类的参数
        //将这些参数复制到一个新的数组中
        String[] progArgs  = new  String[args.length -1 ];
        System.arraycopy(args,1,progArgs,0,progArgs.length);
        CompileClassLoader ccl = new CompileClassLoader();
        Class<?> clazz = ccl.loadClass(progClass);
        //加载需要运行的类
        Method main  = clazz.getMethod("main",(new String[0]).getClass());
        Object argsArray[] = {progArgs};
        main.invoke(null,argsArray);
    }
}
