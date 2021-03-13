package com.person.cn.demotestone.thread.synchronize;

/**
 * @author ym.y
 * @description 两个线程同时访问同步方法和非同步方法
 * @package com.person.cn.demotestone.thread.synchronize
 * @updateUser
 * @date 10:22 2020/12/25
 */
public class SynchronizeTest4 implements Runnable {
    private static SynchronizeTest4 syn = new SynchronizeTest4();
    private static SynchronizeTest4 syn2 = new SynchronizeTest4();

    @Override
    public void run() {
//        info();
//        info2();
        if (Thread.currentThread().getName().equals("Thread-0")) {
            info();
        } else {
            info2();
        }
    }

    public synchronized void info() {
        System.out.println("同步方法，线程：" + Thread.currentThread().getName() + ",开始执行");
        System.out.println("哈哈");
        System.out.println("同步方法，线程：" + Thread.currentThread().getName() + ",执行结束");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void info2() {
        System.out.println("非同步方法，线程：" + Thread.currentThread().getName() + ",开始执行");
        System.out.println("哈哈2");
        System.out.println("非同步方法，线程：" + Thread.currentThread().getName() + ",执行结束");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(syn);
        Thread th2 = new Thread(syn);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}
