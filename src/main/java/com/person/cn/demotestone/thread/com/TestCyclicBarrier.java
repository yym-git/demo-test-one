package com.person.cn.demotestone.thread.com;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description 回还屏障
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 15:192020/11/25
 */
public class TestCyclicBarrier {
    private static CyclicBarrier cyclicBarrier  = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" task merge result");
        }
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+ " task1-1");
                    System.out.println(Thread.currentThread()+ " enter barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+" enter out barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+ " task1-2");
                    System.out.println(Thread.currentThread()+ " enter barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+" enter out barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });


        //关闭线程池
        executorService.shutdown();
    }

}
