package com.person.cn.demotestone.reflect;

import java.lang.reflect.Array;

/**
 * @author ym.y
 * @description 反射操作二维数组
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 16:192020/12/2
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 创建一个长度为10的字符串数组
        Object  arr  = Array.newInstance(String.class,10);
        //为数组下标5位置赋值"疯狂Java讲义"
        Array.set(arr,5,"疯狂Java讲义");
        //为数组下标9位置赋值"轻量级开发""
        Array.set(arr,9,"轻量级开发");
        //取出值
        Object  value1 = Array.get(arr,5);
        Object value2 = Array.get(arr,9);
        System.out.println(value1+"\n"+value2);
    }
}
