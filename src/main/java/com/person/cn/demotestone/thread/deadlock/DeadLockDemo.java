package com.person.cn.demotestone.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description 死锁演示
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 22:12 2021/2/27
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA ="lockA";
        String lockB ="lockB";
        new Thread(new HoldLock(lockA,lockB),"threadA").start();
        new Thread(new HoldLock(lockB,lockA),"threadB").start();
    }
}

class HoldLock implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "持有锁"+lockA+"尝试获取锁"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "持有锁"+lockB+"尝试获取锁"+lockA);
            }
        }
    }
}
