package com.person.cn.practices.threadpratice.base;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 17:08 2021/3/20
 */
public class InterruptCompare {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        },"threadOne");

        //启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志 true
        System.out.println(Thread.currentThread().getName()+":"+threadOne.isInterrupted());
        //interrupted()为Thread类的静态方法,以下代码其实判断的是当前的线程状态   true
        System.out.println(Thread.currentThread().getName()+":"+threadOne.interrupted());
        //false 判断的是当前线程(主线程）的中断状态
        System.out.println(Thread.currentThread().getName()+":"+Thread.interrupted());
        //true
        System.out.println(Thread.currentThread().getName()+":"+threadOne.isInterrupted());
        threadOne.join();

    }
}
