package com.person.cn.demotestone.thread.practices;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 22:55 2020/12/27
 */
public class MultiThreadsError implements Runnable {
    private static int num = 0;
    private final boolean[] index = new boolean[200000];
    private static AtomicInteger realIndex = new AtomicInteger(0);
    private static AtomicInteger wrongCount = new AtomicInteger(0);
    CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
    static MultiThreadsError instance = new MultiThreadsError();


    @Override
    public void run() {
        index[0] = true;
        for (int i = 0; i < 10000; i++) {
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            num++;
            try {
                cyclicBarrier2.await();
                cyclicBarrier1.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance){
                if (index[num]) {
                    System.out.println("发生错误：" + num);
                    wrongCount.incrementAndGet();
                }
                index[num] = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("运行结果：" + num);
        System.out.println("正确运行次数：" + realIndex);
        System.out.println("错误次数：" + wrongCount);

    }
}
