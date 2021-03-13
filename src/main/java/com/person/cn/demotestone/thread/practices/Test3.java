package com.person.cn.demotestone.thread.practices;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 9:58 2021/1/7
 */
public class Test3 {
    private static volatile int count = 0;
    private static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (obj) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        }
                    }
                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (obj) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        }
                    }
                }
            }
        },"奇数").start();
    }
}
