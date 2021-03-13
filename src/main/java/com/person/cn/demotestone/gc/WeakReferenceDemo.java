package com.person.cn.demotestone.gc;

import java.lang.ref.WeakReference;

/**
 * @author ym.y
 * @description 弱引用演示
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 0:30 2021/3/1
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        System.out.println(obj);
        System.out.println(weakReference.get());

        obj = null;
        System.gc();
        System.out.println("GCh后\n\n");
        System.out.println(obj);
        System.out.println(weakReference.get());
    }
}
