package com.person.cn.practices.threadpratice.base;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description
 * 主线程调用线程threadOne.join()方法会阻塞主线程，当threadTwo中调用了主线程的interrupt()方法后，threadOne.join()会发生
 * java.lang.InterruptedException异常
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 23:13 2021/3/19
 */
public class JoinTest2 {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run!");
                for (; ; ) {

                }
            }
        });
        Thread mainThread = Thread.currentThread();
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //线程threadTwo调用了主线程的interrupt()方法
                mainThread.interrupt();
            }
        });

        threadOne.start();
        threadTwo.start();
        try {
            //主线程调用了线程threadOne的join()方法后，主线程阻塞
            //当其他线程调用了主线程的interrupt()方法时，该处会发生异常
            threadOne.join();
            System.out.println("=========");
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
            e.printStackTrace();
        }
    }
}
