package com.person.cn.demotestone.thread.flowcontroller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description 演示多等一/一等多：多个运动员等待裁判吹口哨，才开始跑步
 * @package com.person.cn.demotestone.thread.flowcontroller
 * @updateUser
 * @date 21:28 2021/1/2
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        System.out.println("NO." + no + "开始跑步......");
                        Thread.sleep((long) Math.random() * 1000);
                        System.out.println("NO." + no + "达到终点.......");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                }
            };
            executor.submit(runnable);
        }
        try {
            //裁判员吹开始比赛口哨
            System.out.println("各运动员开始准备.......");
            Thread.sleep(5000);
            System.out.println("发令枪响，开始比赛......");
            begin.countDown();
            //等待所有运动员跑步结束
           end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("--------------比赛结束-------------");
    }
}
