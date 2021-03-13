package com.person.cn.demotestone.thread.condition.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition.test2
 * @updateUser
 * @date 14:23 2021/1/12
 */
public class MyService {
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition NOT_FULL = LOCK.newCondition();
    private static final Condition NOT_EMPTY = LOCK.newCondition();
    private static final List<String> LST = new ArrayList<>();
    private final int MAX_SIZE = 10;


    /**
     * @description 添加元素
     * @author ym.y
     * @updateUser
     * @date 14:32 2021/1/12
     */
    public void put() {
        LOCK.lock();
        try {
            if (MAX_SIZE == LST.size()) {
                //队列满
                System.out.println(Thread.currentThread().getName() + "数组满了，等待");
                try {
                    NOT_FULL.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //不满，生产元素
            int  num = new  Random().nextInt(10);
            System.out.println(Thread.currentThread().getName()+"添加元:"+num);
            LST.add(String.valueOf(num));
            //唤醒等待的线程
            NOT_EMPTY.signal();

        } finally {
            LOCK.unlock();
        }
    }


    /**
     * @description 获取元素
     * @author ym.y
     * @updateUser
     * @date 14:32 2021/1/12
     */
    public void get() {
        LOCK.lock();
        try {
            if (LST.size() == 0) {
                //数组空
                try {
                    NOT_EMPTY.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //不空
            System.out.println(Thread.currentThread().getName() + "移除元素：" + LST.remove(0));
            NOT_FULL.signal();
        } finally {
            LOCK.unlock();
        }
    }
}
