package com.person.cn.practices.threadpratice.base;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 15:55 2021/3/19
 */
public class FooBar {
    ReentrantLock reentrantLock = new ReentrantLock();
    public void foo(){
        reentrantLock.lock();
        try{
            for(int i =0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+"foo");
            }
        }finally {
            reentrantLock.unlock();
        }

    }

    public void bar(){
        reentrantLock.lock();
        try{
            for(int i =0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+"bar");
            }
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fooBar.bar();
            }
        },"线程一").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                fooBar.foo();
            }
        },"线程二").start();
    }
}
