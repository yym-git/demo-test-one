package com.person.cn.demotestone.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author ym.y
 * @description System.out.println(" 本机CPU核数 ： " + Runtime.getRuntime ().availableProcessors());
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 14:50 2021/2/27
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i <= 12; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t办理业务");
            });
        }
        while(!executorService.isTerminated()){
            executorService.shutdown();
        }
    }
}
