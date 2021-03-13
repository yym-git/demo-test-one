package com.person.cn.demotestone.thread.condition;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description 多生生产者/多消费者
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 15:40 2021/1/7
 */
public class ConditionDemo4 {
    static ReentrantLock lock = new ReentrantLock();
//    static boolean flags = true;
    static ArrayList<String> list = new ArrayList<String>();
    static int num = 5; /* 仓库容量为5 */
    static Condition notEmpty = lock.newCondition();
    static Condition notFull = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Runnable producer = () ->
        {
            try {
                lock.lock();
                while (true) {
                    Thread.sleep(100);
                    // 仓库没满
                    if (list.size() != num) {
                        System.out.println(
                                Thread.currentThread()
                                        .getName()
                                        + "：生产了一个货物！"
                        );
                        list.add("货物");
                    }
                    if (list.size() == num) {
                        notFull.await();
                        notEmpty.signalAll();
                    }
                    /* 一个生产者只生成一个就行 */
                    notFull.signalAll();/* 叫别的兄弟来干 */
                    notEmpty.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        Runnable consumer = () ->
        {
            try {
                lock.lock();
                while (true) {
                    Thread.sleep(500);
                    if (list.size() != 0) {
                        System.out.println(
                                Thread.currentThread()
                                        .getName()
                                        + "：消费了一个货物！"
                        );
                        list.remove(0);
                    }
                    if (list.size() == 0) /* 货物全部拿光了 */ {
                        System.out.println(Thread.currentThread().getName()+":队列为空,无法取数据");
                        notEmpty.signalAll();
                        notFull.await();
                    }
                    /*
                     * 一个人只拿一个
                     */
                    notFull.signalAll();/* 叫别的兄弟来消费 */
                    notFull.await();

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        Thread A = new Thread(producer, "生产者A");
        Thread B = new Thread(consumer, "消费者B");
        Thread B1 = new Thread(consumer, "消费者B1");
        Thread B2 = new Thread(consumer, "消费者B2");
        Thread A1 = new Thread(producer, "生产者A1");
        Thread A2 = new Thread(producer, "生产者A2");
        A.start();
        A1.start();
        A2.start();
        B.start();
        B1.start();
        B2.start();
    }
}

