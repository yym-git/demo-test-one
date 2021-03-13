package com.person.cn.demotestone.test.producerandconsumer;

import javax.management.MXBean;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test.producerandconsumer
 * @updateUser
 * @date 19:56 2021/1/12
 */
public class MyService {
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final int MAX_SIZE = 10;
    private static final Condition NOT_EMPTY = LOCK.newCondition();
    private static final Condition NOT_FULL = LOCK.newCondition();
    private static final BlockingQueue<String> QUEUE = new ArrayBlockingQueue<>(MAX_SIZE);

    /**
     * @description 添加元素
     * @author ym.y
     * @updateUser
     * @date 20:05 2021/1/12
     */
    public void put() {
        LOCK.lock();
        try {
            if (QUEUE.size() == MAX_SIZE) {
                try {
                    System.out.println(Thread.currentThread().getName() + "：队列满，等待");
                    NOT_FULL.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //取数据
            Random random = new Random();
            int num  = random.nextInt(10);
            try {
                QUEUE.put(String.valueOf(num));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "添加数据："+num);
            //唤醒等待线程
            NOT_EMPTY.signal();
        } finally {
            LOCK.unlock();
        }

    }

    /**
     * @description 获取元素
     * @author ym.y
     * @updateUser
     * @date 20:05 2021/1/12
     */
    public void get() {
        LOCK.lock();
        try {
            if (QUEUE.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName()+"：队列为空，等待");
                    NOT_FULL.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //取数据
            System.out.println(Thread.currentThread().getName()+"取出数据："+QUEUE.poll());
            //唤醒
            NOT_EMPTY.signal();
        } finally {
            LOCK.unlock();
        }
    }


}
