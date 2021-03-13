package com.person.cn.demotestone.thread.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description Condition实现生产者消费者模式
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 22:59 2021/1/2
 */
public class ConditionDemo2 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        ConditionDemo2 conditionDemo2 = new ConditionDemo2();
        Producer producer = conditionDemo2.new Producer();
        Consumer consumer = conditionDemo2.new Consumer();
        new  Thread(producer).start();
        new Thread(consumer).start();


    }
    //生产者
    class Producer implements  Runnable{
        @Override
        public void run() {
            produce();
        }

        private  void produce(){
            while(true){
                lock.lock();
                try {
                    if(queue.size() == 10){
                        //如果队列满了，不满的条件进入等待
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("放入一个元素");
                    queue.offer(1);
                    //唤醒等待的线程
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements  Runnable{
        @Override
        public void run() {
            consume();
        }

        private  void  consume(){
            try {
                lock.lock();
                while(true){
                    if(queue.size()  == 0){
                        //队列为空，不空的条件阻塞
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //队列不空，取出一个元素
                    queue.poll();
                    //唤醒等待
                    notFull.signal();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size());
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
