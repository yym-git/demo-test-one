package com.person.cn.demotestone.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author ym.y
 * @description 虚引用演示
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 14:36 2021/3/1
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj,referenceQueue);
        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("================");
        obj = null;
        System.gc();
        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
}
