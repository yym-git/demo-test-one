package com.person.cn.demotestone.thread.com;

import java.util.concurrent.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 21:582020/11/25
 */
public class FutureTaskTest {
    private  static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1L, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1,1,1L, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        //添加任务one
        Future futureOne = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start runnable one");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //添加任务two
       Future futureTwo  =  threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start runnable two");

            }
        });

       //添加任务three
        Future futureThree = null;
        try {
            futureThree = threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start runnable three");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        //等待任务one执行完毕
        System.out.println("task one "+futureOne.get());
        System.out.println("task two "+futureTwo.get());
        System.out.println("task three "+(futureThree == null ? null : futureThree.get()));
        threadPoolExecutor.shutdown();
    }
}
