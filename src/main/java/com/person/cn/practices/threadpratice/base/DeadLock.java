package com.person.cn.practices.threadpratice.base;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 17:31 2021/3/20
 */
public class DeadLock {
    private  static final  Object objA = new Object();
    private  static final  Object objB = new Object();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA){
                    System.out.println(Thread.currentThread().getName()+"\t获取到锁objA");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objB){
                        System.out.println(Thread.currentThread().getName()+"\t获取到锁objB");
                    }
                }
            }
        },"threadOne");

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objB){
                    System.out.println(Thread.currentThread().getName()+"\t获取到锁objB");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objA){
                        System.out.println(Thread.currentThread().getName()+"\t获取到锁objA");
                    }
                }
            }
        },"threadTwo");

        threadOne.start();
        threadTwo.start();
    }
}
