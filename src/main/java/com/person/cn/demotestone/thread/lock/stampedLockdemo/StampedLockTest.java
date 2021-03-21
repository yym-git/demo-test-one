package com.person.cn.demotestone.thread.lock.stampedLockdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * @author ym.y
 * @description 悲观读+ 写锁
 * @package com.person.cn.demotestone.thread.lock.stampedLockdemo
 * @updateUser
 * @date 22:10 2021/3/21
 */
public class StampedLockTest {
    private static final StampedLock lock = new StampedLock();
    //缓存中存储的数据
    private static Map<String, String> mapCache = new HashMap<String, String>();
    //模拟数据库存储的数据
    private static Map<String, String> mapDb = new HashMap<String, String>();

    static {
        mapDb.put("zhangsan", "你好，我是张三");
        mapDb.put("sili", "你好，我是李四");
    }

    private static String getInfo(String name) {
        //获取悲观读
        long stamp = lock.readLock();
        try {
            String info = mapCache.get(name);
            if (null != info) {
                System.out.println(Thread.currentThread().getName() + "在缓存中获取到了数据");
                return info;
            }
        } finally {
            //释放悲观读
            lock.unlock(stamp);
        }
        //获取写锁
        stamp = lock.writeLock();
        try {
            //判断一下缓存中是否被插入了数据
            String info = mapCache.get(name);
            if (null != info) {
                System.out.println(Thread.currentThread().getName() + "获取到了写锁，再次确认在缓存中获取到了数据");
                return info;
            }
            //这里是往数据库获取数据
            String infoByDb = mapDb.get(name);
            //讲数据插入缓存
            mapCache.put(name, infoByDb);
            System.out.println(Thread.currentThread().getName() + "缓存中没有数据，在数据库获取到了数据");
        } finally {
            //释放写锁
            lock.unlock(stamp);
        }
        return null;
    }

    public static void main(String[] args) {
        //线程1
        Thread t1 = new Thread(() -> {
            getInfo("zhangsan");
        }, "threadA");
        //线程2
        Thread t2 = new Thread(() -> {
            getInfo("zhangsan");
        }, "threadB");
        //线程启动
        t1.start();
        t2.start();
        //线程同步
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
