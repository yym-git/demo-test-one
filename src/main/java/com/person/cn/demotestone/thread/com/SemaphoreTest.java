package com.person.cn.demotestone.thread.com;

import java.util.concurrent.*;

/**
 * @author ym.y
 * @description 信号量
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 16:172020/11/25
 */
public class SemaphoreTest {
    //创建一个信号量实例
    private  static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
       ExecutorService executorService =  Executors.newFixedThreadPool(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                5,1,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1执行完毕....");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2执行完毕....");
                semaphore.release();
            }
        });
        //等待子线程执行完毕返回
        try {
            semaphore.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束");
        //关闭线程池
        executorService.shutdown();
    }
}
