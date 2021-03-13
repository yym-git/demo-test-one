package com.person.cn.demotestone.thread.lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ym.y
 * @description 自定义自旋锁
 * @package com.person.cn.demotestone.thread.lock.spinlock
 * @updateUser
 * @date 10:56 2020/12/31
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
            System.out.println(Thread.currentThread().getName()+"获取锁失败，尝试再次获取....");
        }
    }

    public void unlock() {
        sign.compareAndSet(Thread.currentThread(), null);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始尝试获取锁");
                    spinLock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取到了锁");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName()+"释放了锁！");
                    spinLock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

    }
}
