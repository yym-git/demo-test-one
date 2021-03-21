package com.person.cn.demotestone.thread.flowcontroller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.flowcontroller
 * @updateUser
 * @date 21:02 2021/1/2
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("游客" + num + "已经安检完成了....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //每启动一个线程，state的值-1
                        countDownLatch.countDown();
                    }
                }
            };
            executor.submit(runnable);
        }
        System.out.println("等待5名游客安检......");
        try {
            // await()方法相当于一个阀门，等到state=0时，程序往下执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("安检完成，进入下一个景点....");
    }
}
