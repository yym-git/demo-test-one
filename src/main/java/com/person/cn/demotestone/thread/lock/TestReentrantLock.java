package com.person.cn.demotestone.thread.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock
 * @updateUser
 * @date 22:312020/11/19
 */
public class TestReentrantLock {
    public static void main(String[] args) throws Exception {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.writeLock().lock();
        reentrantLock.lock();
        reentrantLock.unlock();
        //优先级阻塞队列
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue();
        priorityBlockingQueue.offer("");




    }
}
