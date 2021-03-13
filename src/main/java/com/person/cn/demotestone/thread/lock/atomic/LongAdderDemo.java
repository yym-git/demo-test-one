package com.person.cn.demotestone.thread.lock.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ym.y   refresh
 * @description 演示高并发情况下 AtomicLong的性能比LongAdder低
 * @package com.person.cn.demotestone.thread.lock.atomic
 * @updateUser
 * @date 13:06 2020/12/31
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        long  start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        counter.increment();
                    }
                }
            });
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){}
        long end  = System.currentTimeMillis();
        System.out.println("LongAdder耗时："+(end-start)+"\t"+counter.sum());
    }
}
