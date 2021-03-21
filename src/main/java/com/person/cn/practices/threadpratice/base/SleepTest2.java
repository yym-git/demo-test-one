package com.person.cn.practices.threadpratice.base;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description 线程A调用sleep()方法进入休眠状态，线程B调用线程A的interrupt()方法时会抛出interruptException异常
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 23:45 2021/3/19
 */
public class SleepTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程一准备进入休眠");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        //主线程休眠2秒
        TimeUnit.SECONDS.sleep(2);
        //主线程中断threadOne线程--抛出interruptException
        thread.interrupt();
    }
}
