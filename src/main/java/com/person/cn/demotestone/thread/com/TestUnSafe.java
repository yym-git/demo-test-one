package com.person.cn.demotestone.thread.com;

import sun.misc.Contended;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 21:322020/11/16
 */
@Contended
public class TestUnSafe {
    static   Unsafe unsafe = null;
    static  long   stateOffset;
    private volatile long state = 0;
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe)theUnsafe.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnSafe testUnSafe = new TestUnSafe();
        boolean flag  = unsafe.compareAndSwapInt(testUnSafe,stateOffset,0,1);
        System.out.println("=======flag====="+flag);
    }
}
