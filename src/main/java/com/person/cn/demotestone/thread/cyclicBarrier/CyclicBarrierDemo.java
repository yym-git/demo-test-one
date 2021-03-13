package com.person.cn.demotestone.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.cyclicBarrier
 * @updateUser
 * @date 0:12 2021/1/3
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有人都到了，大家统一出发");
            }
        });
        for(int i =1; i<=10; i++){
            new Thread(new Task(i,cyclicBarrier)).start();
        }
    }

    static class Task implements Runnable {
        private int id;
        private CyclicBarrier barrier;

        public Task(int id, CyclicBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + id + "现在前往集合地点");
            try {
                Thread.sleep((long) Math.random() * 10000);
                System.out.println("线程" + id + "到了集合地点，开始等待其他人到达");
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



