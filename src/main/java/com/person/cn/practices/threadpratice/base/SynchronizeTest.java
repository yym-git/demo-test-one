package com.person.cn.practices.threadpratice.base;

/**
 * @author ym.y
 * @description
 * wait()方法会阻塞当前线程，并且释放当前线程持有的锁资源
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 17:54 2021/3/19
 */
public class SynchronizeTest {
    private static volatile Object objA = new Object();
    private static volatile Object objB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (objA) {
                        System.out.println(Thread.currentThread().getName() + "获取objA");
                        synchronized (objB) {
                            System.out.println(Thread.currentThread().getName() + "获取objB");
                            System.out.println(Thread.currentThread().getName() + "释放objA");
                            //释放objA锁，线程阻塞
                            objA.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"ThreadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (objA){
                        System.out.println(Thread.currentThread().getName() + "获取objA");
                        System.out.println(Thread.currentThread().getName() + "try获取objB");
                        synchronized (objB){
                            System.out.println(Thread.currentThread().getName() + "get获取objB");
                            System.out.println(Thread.currentThread().getName() + "释放objB");
                            objA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadB");

        threadA.start();
        threadB.start();
    }

}
