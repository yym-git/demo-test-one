package com.person.cn.demotestone.thread.lock.reentrantreadwritelock;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock.reentrantreadwritelock
 * @updateUser
 * @date 20:46 2021/2/25
 */
@Slf4j
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //5个线程同时写
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(String.valueOf(tempInt), tempInt);
            }, String.valueOf(i)).start();
        }

        //5个线程同时读
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(String.valueOf(tempInt));
            }, String.valueOf(i)).start();
        }
    }
}


/**
 * @author ym.y
 * @description 缓存类
 * @updateUser
 * @date 21:30 2021/2/25
 */
@Slf4j
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * @description 存数据
     * @author ym.y
     * @updateUser
     * @date 21:13 2021/2/25
     */
    public void put(String key, Object value) {

        try {
            rwLock.writeLock().lock();
            log.info(Thread.currentThread().getName() + "\t正在写入：{}", key);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            log.info(Thread.currentThread().getName() + "\t写入完成");
        } finally {
            rwLock.writeLock().unlock();
        }

    }


    /**
     * @description 取数据
     * @author ym.y
     * @updateUser
     * @date 21:14 2021/2/25
     */
    public void get(String key) {

        try {
            rwLock.readLock().lock();
            log.info(Thread.currentThread().getName() + "\t正在读取：{}", key);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            log.info(Thread.currentThread().getName() + "\t读取完成：{}", result);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
