package com.person.cn.demotestone.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author ym.y
 * @description引用队列
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 14:29 2021/3/1
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        //将对象放入引用队列中
        WeakReference<Object> weakReference = new WeakReference<>(object,referenceQueue);
        System.out.println(object);
        System.out.println(weakReference.get());
        //打印结果为 null
        System.out.println(referenceQueue.poll());
        System.out.println("CG之后..................");
        object = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(object);
        System.out.println(weakReference.get());
        //打印结果不为 null
        System.out.println(referenceQueue.poll());

    }
}
