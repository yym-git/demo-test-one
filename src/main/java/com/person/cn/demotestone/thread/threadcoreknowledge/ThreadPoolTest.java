package com.person.cn.demotestone.thread.threadcoreknowledge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description 线程池创建线程
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 13:02 2020/12/25
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
