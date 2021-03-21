package com.person.cn.practices.threadpratice.base;


import java.util.concurrent.Semaphore;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 15:55 2021/3/19
 */
public class FooBar2 {
    Semaphore semaphore = new Semaphore(1);
    public void foo(){
        try{
            semaphore.acquire();
            for(int i =0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+"foo");
            }
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }

    public void bar(){
        try{
            semaphore.acquire();
            for(int i =0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+"bar");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        FooBar2 fooBar = new FooBar2();
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
