package com.person.cn.demotestone.thread.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description 可重入粒度：类方法中调用不同类的方法
 * @package com.person.cn.demotestone.thread.synchronize
 * @updateUser
 * @date 11:13 2020/12/25
 */
public class SynchronizeTest9 {
    public synchronized void method1() {
        System.out.println("method1");
        method2();
    }
    public synchronized void method2() {
        System.out.println("method2");
    }

    public static void main(String[] args) {
        Lock  lock = new ReentrantLock();
        new SynchronizeTest9().method1();
    }
}
