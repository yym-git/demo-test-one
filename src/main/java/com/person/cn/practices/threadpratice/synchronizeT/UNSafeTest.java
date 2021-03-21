package com.person.cn.practices.threadpratice.synchronizeT;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadpratice.synchronizeT
 * @updateUser
 * @date 22:36 2021/3/20
 */
public class UNSafeTest {
    static  Unsafe unSale;
    private volatile long state = 2;
    static long stateOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            //反射通过变量获取对象，如果变量为静态变量可以传入null，否则报错
            unSale =(Unsafe) field.get(null);
            //获取state变量在类UNSafeTest类中偏移量位置
            stateOffset = unSale.objectFieldOffset(UNSafeTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UNSafeTest unSafeTest = new UNSafeTest();
        boolean success = unSale.compareAndSwapInt(unSafeTest, stateOffset, 0, 1);
        System.out.println("更新结果：" + success);
    }
}
