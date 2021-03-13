package com.person.cn.demotestone.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ym.y
 * @description 利用反射创建一个带标题名的窗口
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 14:372020/12/2
 */
public class CreateJFrame {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> jf = Class.forName("javax.swing.JFrame");
        Constructor actor =  jf.getConstructor(String.class);
        Object obj  = actor.newInstance("测试窗口");
        System.out.println(obj);
    }
}
