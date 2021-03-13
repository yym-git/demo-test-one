package com.person.cn.demotestone.thread.flowcontroller;

import lombok.extern.slf4j.Slf4j;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.CountDownLatch;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.flowcontroller
 * @updateUser
 * @date 14:06 2021/2/26
 */
@Slf4j
public class CountDownLatchDemo3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int  i =1; i<=6; i++){
            new  Thread(()->{
                log.info(Thread.currentThread().getName()+"\t上完自习离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        log.info(Thread.currentThread().getName()+"班长最后关门走人");
    }
}
