package com.person.cn.demotestone.thread.practices;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 9:56 2020/12/28
 */
public class DeadLock {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println("1获取资源1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println("1获取资源2");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    System.out.println("2获取资源2");
                    synchronized (obj1) {
                        System.out.println("2获取资源1");
                    }
                }
            }
        }).start();
    }
}
