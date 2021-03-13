package com.person.cn.demotestone.thread.lock.reentrantlock;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description 演示ReentrantLock的可重入性：递归调用
 * @package com.person.cn.demotestone.thread.lock.reentrantlock
 * @updateUser
 * @date 15:04 2020/12/30
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    public static void test() {
        lock.lock();
        try {
            System.out.println("获取到了锁");
            System.out.println("对资源进行了处理！");
            if(lock.getHoldCount()<5){
                System.out.println("重入次数："+lock.getHoldCount());
                test();
                System.out.println("重入次数："+lock.getHoldCount());
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
