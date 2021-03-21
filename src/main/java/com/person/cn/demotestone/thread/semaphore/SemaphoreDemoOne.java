package com.person.cn.demotestone.thread.semaphore;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.semaphore
 * @updateUser
 * @date 22:03 2021/1/2
 */
public class SemaphoreDemoOne {
    private static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executor.submit(new Task());
        }
        executor.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                // state减1
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "获取到了许可证");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //state 加 1
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "释放了许可证");
            }
        }
    }
}
