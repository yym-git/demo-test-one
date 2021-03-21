package com.person.cn.practices.threadpratice.base;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 17:54 2021/3/19
 */
public class SynchronizeTest2 {
    private static volatile Object objA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + " get objA");
                    try {
                        System.out.println(Thread.currentThread().getName() + " begin wait");
                        //释放当前对象锁
                        objA.wait();
                        System.out.println(Thread.currentThread().getName() + " wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "threadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + " get objA");
                    try {
                        System.out.println(Thread.currentThread().getName() + " begin wait");
                        objA.wait();
                        System.out.println(Thread.currentThread().getName() + " wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "threadB");

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + " 开始notify");
                    objA.notify();
                }
            }
        }, "threadC");
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over!");
    }
}
