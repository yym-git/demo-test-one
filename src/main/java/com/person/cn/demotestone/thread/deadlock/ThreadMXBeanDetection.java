package com.person.cn.demotestone.thread.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author ym.y
 * @description 用ThreadMXBean死锁的检测
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 18:08 2020/12/28
 */
public class ThreadMXBeanDetection implements Runnable {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    int flag = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadMXBeanDetection r1 = new ThreadMXBeanDetection();
        ThreadMXBeanDetection r2 = new ThreadMXBeanDetection();
        r1.flag = 1;
        r2.flag = 0;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //查找死锁线程
        long[] deadLockThreads = threadMXBean.findDeadlockedThreads();
        if (deadLockThreads != null && deadLockThreads.length > 0) {
            for (int i = 0; i < deadLockThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadLockThreads[i]);
                System.out.println("线程名：" + threadInfo.getThreadName());
            }
        }
    }

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (obj1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("线程1成功获取到2把锁！");
                }
            }
        }
        if (flag == 0) {
            synchronized (obj2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("线程2成功获取到2把锁！");
                }
            }
        }
    }
}