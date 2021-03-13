package com.person.cn.demotestone.thread.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock.reentrantreadwritelock
 * @updateUser
 * @date 16:59 2020/12/30
 */
public class ReentrantReadWriteLockTest {
    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private static ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();

    public static void main(String[] args) {
        new Thread(() -> readInfo(), "readLock_1").start();
        new Thread(() -> readInfo(), "readLock_2").start();
        new Thread(() -> writeInfo(), "writeLock_1").start();
        new Thread(() -> writeInfo(), "writeLock_2").start();
    }

    public static void readInfo() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到了读锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
        } finally {
            readLock.unlock();
        }
    }

    public static void writeInfo() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到了写锁");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
        } finally {
            writeLock.unlock();
        }

    }
}