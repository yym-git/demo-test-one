package com.person.cn.practices.threadpratice.base;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description 通过调用等待线程的interrupt()方法，主动打破等待时间，不一定等到指定时间后才复苏
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 16:58 2021/3/20
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName()+"\t begin sleep 2000秒");
                    TimeUnit.SECONDS.sleep(20000);
                }catch (InterruptedException e){
                    System.out.println("thread线程在sleep期间被打断");
                }
                System.out.println(Thread.currentThread().getName()+"\t 正常结束！");
            }
        });
        //启动thread线程
        thread.start();
        //主线程休眠，确保thread线程进入休眠
        Thread.sleep(1000);
        //由主线程打断子线程的休眠状态，这样子线程就不定需要等到20000秒后才执行完
        thread.interrupt();
        //等待子线程执行完
        thread.join();
        System.out.println("主线程执行完毕！");
    }
}
