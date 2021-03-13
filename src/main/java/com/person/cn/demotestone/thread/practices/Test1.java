package com.person.cn.demotestone.thread.practices;

/**
 * @author ym.y
 * @description 两个线程交替打印100以内的奇偶数,synchronize方式
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 18:48 2020/12/26
 */
public class Test1 {
    private static int count = 0;
    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "奇数").start();

    }
}
