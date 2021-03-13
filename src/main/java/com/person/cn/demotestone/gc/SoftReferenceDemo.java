package com.person.cn.demotestone.gc;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/**
 * @author ym.y
 * @description 软引用： 内存足够，不回收，内存不够，回收
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 23:52 2021/2/28
 */
public class SoftReferenceDemo {
    /**
     * @description 内存足够
     * @author ym.y
     * @updateUser
     * @date 23:55 2021/2/28
     */
    public static void soft_memory_enough() {
        Object obj = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj);
        System.out.println(obj);
        System.out.println(softReference);
        System.gc();
        System.out.println("GC后");
        obj = null;
        System.out.println(obj);
        System.out.println(softReference);

    }


    /**
     * @description 内存不够用时回收
     * -Xms5m -Xmx5m  -XX:+PrintGCDetails
     * @author ym.y
     * @updateUser
     * @date 23:59 2021/2/28
     */
    public static void soft_memory_enough_not() {
        Object obj =new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj);
        System.out.println(obj);
        System.out.println(softReference.get());
        obj =null;
        System.gc();
        try {
            byte[] bytes = new  byte[50*1024*1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println("==========内存溢出后==========");
            System.out.println(obj);
            System.out.println(softReference.get());
        }

    }

    public static void main(String[] args) {
//        soft_memory_enough();
        soft_memory_enough_not();
    }
}
