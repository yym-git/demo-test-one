package com.person.cn.demotestone.reflect;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author ym.y
 * @description
 * 简单对象池的实现：根据配置文件读取key-value对，然后创建对象，并将这些对象
 * 放入HashMap中
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 14:072020/12/2
 */
public class ObjectPoolFactory {
    private HashMap<String,Object> objectPool = new HashMap<>();
    /**
     * @description   根据类名创建对象
     * @author ym.y
     * @updateUser
     * @date  14:14 2020/12/2
     */
    private  Object createObject(String  clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
      Class<?> clazz =   Class.forName(clazzName);
      return clazz.getConstructor().newInstance();
    }

    /**
     * @description 根据指定的文件名来初始化对象池
     * @author ym.y
     * @updateUser
     * @date  14:15 2020/12/2
     */
    public void initPool(String  fileName){
        try {
            FileInputStream fis  = new FileInputStream(fileName);
            Properties props = new Properties();
            props.load(fis);
            for(String name  : props.stringPropertyNames()){
                objectPool.put(name,createObject(props.getProperty(name)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Object getObject(String name){
        return  objectPool.get(name);
    }
    public static void main(String[] args) {
     ObjectPoolFactory opf =    new ObjectPoolFactory();
        /**
         * obj.txt文件内容:
         * a=java.util.Date
         * b=javax.swing.JFrame
         */
        opf.initPool("D://obj.txt");
        System.out.println(opf.getObject("a"));
        System.out.println(opf.getObject("b"));
    }
}
