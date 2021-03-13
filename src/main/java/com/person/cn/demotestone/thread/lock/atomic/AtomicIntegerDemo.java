package com.person.cn.demotestone.thread.lock.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock.atomic
 * @updateUser
 * @date 11:55 2020/12/31
 */
public class AtomicIntegerDemo implements Runnable {
    private static  final AtomicInteger atomicInteger = new AtomicInteger();

    public void atomicIncrement() {
        atomicInteger.incrementAndGet();
    }

    private static volatile int basicCount = 0;

    public synchronized  void basicIncrement() {
        basicCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomicIncrement();
            basicIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        Thread th1 = new Thread(atomicIntegerDemo);
        Thread th2 = new Thread(atomicIntegerDemo);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("原子值："+atomicInteger.get());
        System.out.println("非原子："+basicCount);
    }
}
