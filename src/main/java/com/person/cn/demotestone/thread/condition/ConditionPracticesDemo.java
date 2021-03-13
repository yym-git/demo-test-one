package com.person.cn.demotestone.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description 描述：多线程之间的顺序执行，实现A-B-C三个线程的顺序执行，要求：
 * A线程打印5次
 * B线程打印10次
 * C线程打印15次
 * 循环10次
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 22:53 2021/2/26
 */
public class ConditionPracticesDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new Thread(() -> {
            for (int i = 1; i <= 2; i++) {
                printer.print1();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 2; i++) {
                printer.print2();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 2; i++) {
                printer.print3();
            }
        }, "C").start();
    }
}


/**
 * @author ym.y
 * @description 资源类
 * @updateUser
 * @date 23:04 2021/2/26
 */
class Printer {
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private int number = 1;

    /**
     * @description 线程A 打印5次
     * @author ym.y
     * @updateUser
     * @date 23:10 2021/2/26
     */
    public void print1() {
        lock.lock();
        try {
            while (number != 1) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number=2;
            //唤醒线程2
            c2.signal();
        } finally {
            lock.unlock();
        }
    }


    /**
     * @description 线程B打印10次
     * @author ym.y
     * @updateUser
     * @date 23:10 2021/2/26
     */
    public void print2() {
        lock.lock();
        try {
            while (number != 2) {
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number=3;
            //唤醒线程2
            c3.signal();
        } finally {
            lock.unlock();
        }
    }


    /**
     * @description 线程C 打印15次
     * @author ym.y
     * @updateUser
     * @date 23:11 2021/2/26
     */
    public void print3() {
        lock.lock();
        try {
            while (number != 3) {
                try {
                    c3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number=1;
            //唤醒线程2
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
