package com.person.cn.demotestone.thread.condition;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.cyclicBarrier
 * @updateUser
 * @date 10:03 2021/1/3
 */
public class ConditionDemo3 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();
    private static PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10);

    public static void main(String[] args) {
        Producer producer = new ConditionDemo3.Producer();
        Consumer consumer = new ConditionDemo3.Consumer();
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    /**
     * @author ym.y
     * @description 生产者
     * @updateUser
     * @date 10:04 2021/1/3
     */
    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep((long)Math.random()*10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.produce();
        }

        private void produce() {
            try {
                lock.lock();
                while (true) {
                    if (queue.size() == 10) {
                        try {
                            //如果队列已经满了，不满的条件等待
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //队列未满，添加元素
                    queue.offer(1);
                    System.out.println("向队列中添加一个元素,剩余空间："+(10-queue.size()));
                    //唤醒等待的线程
                    notEmpty.signal();
                }
            } finally {
                lock.unlock();
            }


        }
    }


    /**
     * @author ym.y
     * @description 消费者类
     * @updateUser
     * @date 10:17 2021/1/3
     */
    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep((long)Math.random()*10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.consume();
        }

        private void consume() {
            try {
                lock.lock();
                while (true) {
                    if (queue.size() == 0) {
                        //如果队列未空，则不空的条件阻塞
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //队列不空，则从队列中取出一个元素
                    queue.poll();
                    System.out.println("取出一个元素,剩余元素："+queue.size());
                    //唤醒等待中的线程
                    notFull.signal();
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
