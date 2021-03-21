package com.person.cn.demotestone.thread.lock.stampedLockdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.StampedLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock.stampedLockdemo
 * @updateUser
 * @date 22:33 2021/3/21
 */
@Slf4j
public class StampedLockTest2 {
    private static final StampedLock lock = new StampedLock();
    //缓存中存储的数据
    private static Map<String,String> mapCache = new HashMap<String, String>();
    //模拟数据库存储的数据
    private static Map<String,String> mapDb = new HashMap<String, String>();
    static {
        mapDb.put("zhangsan","你好，我是张三");
        mapDb.put("sili","你好，我是李四");
    }
    private static String getInfo(String name){
        //获取悲观读
        long stamp = lock.readLock();
        log.info(System.currentTimeMillis()+"\t线程名："+Thread.currentThread().getName()+" 获取了悲观读锁" +" 用户名："+name);
        try{
            if("zhangsan".equals(name)){
                log.info("线程名："+Thread.currentThread().getName()+" 休眠中" +" 用户名："+name+"\n");
                Thread.sleep(5000);
                log.info("线程名："+Thread.currentThread().getName()+" 休眠结束" +" 用户名："+name);
            }
            String info = mapCache.get(name);
            if(null != info){
                log.info(Thread.currentThread().getName()+"在缓存中获取到了数据");
                return info;
            }
        } catch (InterruptedException e) {
            log.info("线程名："+Thread.currentThread().getName()+" 释放了悲观读锁");
            e.printStackTrace();
        } finally {
            //释放悲观读
            lock.unlock(stamp);
        }
        //获取写锁
        stamp = lock.writeLock();
        log.info("线程名："+Thread.currentThread().getName()+" 获取了写锁" +" 用户名："+name);
        try{
            //判断一下缓存中是否被插入了数据
            String info = mapCache.get(name);
            if(null != info){
                log.info(Thread.currentThread().getName()+"获取到了写锁，再次确认在缓存中获取到了数据");
                return info;
            }
            //这里是往数据库获取数据
            String infoByDb = mapDb.get(name);
            //讲数据插入缓存
            mapCache.put(name,infoByDb);
            log.info(Thread.currentThread().getName()+"缓存中没有数据，在数据库获取到了数据");
        }finally {
            //释放写锁
            log.info("线程名："+Thread.currentThread().getName()+" 释放了写锁" +" 用户名："+name);
            lock.unlock(stamp);
        }
        return null;
    }
    public static void main(String[] args) {
        //线程1
        Thread t1 = new Thread(() ->{
            getInfo("zhangsan");
        },"threadA");
        //线程2
        Thread t2 = new Thread(() ->{
            getInfo("lisi");
        },"threadB");
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
