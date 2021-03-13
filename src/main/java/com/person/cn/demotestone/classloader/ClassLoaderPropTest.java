package com.person.cn.demotestone.classloader;

import java.net.URL;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.classloader
 * @updateUser
 * @date 9:372020/12/2
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemClassLoader);
        URL url = systemClassLoader.getResource("");
        System.out.println("系统类加载器URL：" + url);
        //获取系统类加载器的父类加载器，得到扩张类加载器
        ClassLoader extensionLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器："+extensionLoader);
        System.out.println("扩展类加载器的加载路径："+System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的父类："+extensionLoader.getParent());

    }
}
