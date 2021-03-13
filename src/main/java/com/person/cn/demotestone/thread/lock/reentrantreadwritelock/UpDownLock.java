package com.person.cn.demotestone.thread.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ym.y
 * @description 演示ReentrantReadWriteLock锁升级（不允许）和降级（允许）
 * 公平读写锁：按照等待队列的先后执行任务
 * 非公平读写锁：如果阻塞队列的头结点为非写操作，则允许读线程插队
 * @package com.person.cn.demotestone.thread.lock.reentrantreadwritelock
 * @updateUser
 * @date 17:30 2020/12/30
 */
public class UpDownLock {
    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    private static ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private static ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();

    public static void readInfo() {
        System.out.println(Thread.currentThread().getName()+"尝试获取读锁.......");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到了读锁");
            //尝试升级为写锁
            System.out.println("尝试升级为写锁(会阻塞)");
            writeLock.lock();
            System.out.println(Thread.currentThread().getName()+"升级为写锁，成功！");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
            writeLock.unlock();
            readLock.unlock();
        }
    }

    public static void writeInfo() {
        System.out.println(Thread.currentThread().getName()+"尝试获取写锁----------");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到了写锁");
            try {
                Thread.sleep(40);
                System.out.println("尝试降级为读锁---------");
                readLock.lock();
                System.out.println(Thread.currentThread().getName()+"降级为读锁，成功！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
            writeLock.unlock();
        }

    }


    public static void main(String[] args) {
//        new Thread(() -> writeInfo(), "thread_1").start();
        new Thread(() -> readInfo(), "thread_2").start();
    }

}
