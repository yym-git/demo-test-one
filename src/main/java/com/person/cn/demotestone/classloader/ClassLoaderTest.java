package com.person.cn.demotestone.classloader;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.classloader
 * @updateUser
 * @date 17:222020/12/1
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader =  ClassLoader.getSystemClassLoader();
        try {
            //加载Tester类
            classLoader.loadClass("com.person.cn.demotestone.classloader.Tester");
            System.out.println("系统加载Tester类");
            //下面语句初始化Tester类
            Class.forName("com.person.cn.demotestone.classloader.Tester");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Tester{
    static {
        System.out.println("Test类静态初始化块.......");
    }
}
