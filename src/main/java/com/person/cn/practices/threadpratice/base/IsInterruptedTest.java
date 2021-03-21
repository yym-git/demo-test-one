package com.person.cn.practices.threadpratice.base;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 16:48 2021/3/20
 */
public class IsInterruptedTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    //如果当前线程没有中断，则输出以下代码
                    System.out.println(Thread.currentThread()+"\t hello!");
                }
            }
        });
        //启动子线程
        thread.start();
        //休眠主线程
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程中断thread线程");
        thread.interrupt();
        thread.join();
        System.out.println("主线程执行结束");

    }
}
