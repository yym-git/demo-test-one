package com.person.cn.demotestone.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock
 * @updateUser
 * @date 13:43 2020/12/30
 */
public class LockInterruptibly implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁....");
        try {
            //尝试获取锁
            lock.lockInterruptibly();
            //获取到了锁
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了锁！");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "休眠期间被中断");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁！");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "尝试获取锁失败!");
//            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockInterruptibly lockInterruptibly = new LockInterruptibly();
        Thread thread0 = new Thread(lockInterruptibly);
        Thread thread1 = new Thread(lockInterruptibly);
        thread0.start();
        thread1.start();
        Thread.sleep(500);
        thread0.interrupt();

    }
}
