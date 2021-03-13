package com.person.cn.demotestone.reflect;

import org.springframework.core.io.support.PropertiesLoaderSupport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 15:112020/12/2
 */
public class ExtendedObjectPoolFactory {
    private HashMap<String,Object> objectPool = new HashMap<>();
    private Properties  config  = new Properties();

    /**
     * @description 初始化Properties属性
     * @author ym.y
     * @updateUser
     * @date  15:14 2020/12/2
     */
    public  void  init(String  fileName){
        try {
            FileInputStream fis  =  new FileInputStream(fileName);
            config.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @description  使用默认无惨构造器创建对象
     * @author ym.y
     * @updateUser
     * @date  15:16 2020/12/2
     */
    public Object createObject(String  clazzName) throws Exception {
        Class<?> clazz =  Class.forName(clazzName);
        return  clazz.getConstructor().newInstance();
    }

    /**
     * @description 根据类名获取该类名的实际对象
     * @author ym.y
     * @updateUser
     * @date  15:27 2020/12/2
     */
    public  Object getObject(String name){
        return objectPool.get(name);
    }
    /**
     * @description 初始化对象池
     * @author ym.y
     * @updateUser
     * @date  15:18 2020/12/2
     */
    public void initPool() throws Exception {
        for(String  name : config.stringPropertyNames()){
            if(!name.contains("%")){
                //创建对象并放入map中，key为对象名，value为具体的对象
                objectPool.put(name,createObject(config.getProperty(name)));
            }
        }
    }

    /**
     * @description 初始化对象池中对象的属性
     * @author ym.y
     * @updateUser
     * @date  15:22 2020/12/2
     */
    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(String  name : config.stringPropertyNames() ){
            if(name.contains("%")){
                String[] objAndProp = name.split("%");
                //目标对象
                Object target = getObject(objAndProp[0]);
                //获取setter方法名： set+ 首字母大写+ 剩余部分
                String mtName  = "set"+objAndProp[1].substring(0,1).toUpperCase()+objAndProp[1].substring(1);
                Class<?> clazz = target.getClass();
                Method  mtd = clazz.getMethod(mtName,String.class);
                mtd.invoke(target,config.getProperty(name));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExtendedObjectPoolFactory exp = new ExtendedObjectPoolFactory();
        /**
         * extObje.txt文件内容如下：
         * *************************************************************
         *  a=javax.swing.JFrame                                       *
         *  b=javax.swing.JLable                                       *
         *  #a%title表示调用a对象的setTitle()方法                       *
         *  a%title=Test Title                                         *
         *  ************************************************************
         */
        exp.init("D://extObj.txt");
        exp.initPool();
        exp.initProperty();
        System.out.println(exp.getObject("a"));

    }
}
