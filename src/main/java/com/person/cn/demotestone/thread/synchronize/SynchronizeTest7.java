package com.person.cn.demotestone.thread.synchronize;

/**
 * @author ym.y
 * @description 两个线程同时访问一个对象静态同步方法和非静态同步方法
 * @package com.person.cn.demotestone.thread.synchronize
 * @updateUser
 * @date 10:22 2020/12/25
 */
public class SynchronizeTest7 implements Runnable {
    private static SynchronizeTest7 syn = new SynchronizeTest7();
    private static SynchronizeTest7 syn2 = new SynchronizeTest7();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            info();
        } else {
            info2();
        }
    }

    public synchronized void info() {
        System.out.println("同步方法，线程：" + Thread.currentThread().getName() + ",开始执行");
        try {
            Thread.sleep(3000);
            System.out.println("哈哈");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("同步方法，线程：" + Thread.currentThread().getName() + ",执行结束");
        throw new  RuntimeException("执行异常");

    }
    public synchronized void info2() {
        System.out.println("同步方法2，线程：" + Thread.currentThread().getName() + ",开始执行");
        try {
            Thread.sleep(3000);
            System.out.println("哈哈");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("同步方法2，线程：" + Thread.currentThread().getName() + ",执行结束");

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
