package com.person.cn.demotestone.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 22:45 2021/1/2
 */
public class ConditionDemo {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static void methodOne() {
        lock.lock();
        try {
            System.out.println("不满足条件，进入等待......");
            try {
                condition.await();
                System.out.println("满足条件,允许进入");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    private static void methodTwo() {
        lock.lock();
        try {
            System.out.println("准备工作完成，唤醒等待的线程.....");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                conditionDemo.methodTwo();
            }
        }).start();

        conditionDemo.methodOne();
    }
}
