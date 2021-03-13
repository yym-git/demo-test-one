package com.person.cn.demotestone.thread.threadpool;

import org.omg.CORBA.TIMEOUT;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 15:58 2020/12/29
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //1秒后启动，后面每隔3秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Task2(), 1, 3, TimeUnit.SECONDS);
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
    }
}
