package com.person.cn.demotestone.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description  newFixedThreadPool使用的是LinkedBlockingQueue无界队列，当请求越来越多，
 * 并且处理速度慢的情况下会导致内存溢出。
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 15:33 2020/12/29
 */
public class FixedThreadPoolOOM {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int  i  =0; i< Integer.MAX_VALUE; i++){
            executorService.submit(new SubThread());
        }
    }
}

class SubThread implements  Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
