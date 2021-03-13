package com.person.cn.demotestone.thread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description 公平锁和非公平锁
 * 非公平情况下：一个线程会连续打印出1和2
 * 公平情况下：每个线程都会先打印1，然后打印2
 * @package com.person.cn.demotestone.thread.lock.reentrantlock
 * @updateUser
 * @date 15:43 2020/12/30
 */
public class FairAndUnfair {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Printer());
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            Thread.sleep(100);
        }
    }
}


//打印机
class Printer implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始打印");
        PrintQueue.taskJob();
        System.out.println(Thread.currentThread().getName()+"打印结束！\n");
    }
}

//打印操作
class PrintQueue {
    private static ReentrantLock printQueue = new ReentrantLock(false);

    public static void taskJob() {
        printQueue.lock();
        try {
//            int duration = new Random().nextInt(10);
            int duration = 1000;
            System.out.println(Thread.currentThread().getName() + "正在打印1，需要：" + duration/1000 + "秒！");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"打印1完成");
        } finally {
            printQueue.unlock();
        }

        //非公皮锁：当线程0打印1完成后，唤醒线程1时，需要时间，
        // 这段时间线程0又尝试获取锁，此时线程0又获取到了锁，接着打印2
        printQueue.lock();
        try {
//            int duration = new Random().nextInt(10);
            int duration = 2000;
            System.out.println(Thread.currentThread().getName() + "正在打印2，需要：" + duration/1000 + "秒！");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"打印2完成");
        } finally {
            printQueue.unlock();
        }
    }
}
