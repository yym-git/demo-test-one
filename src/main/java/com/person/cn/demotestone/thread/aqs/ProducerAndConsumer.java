package com.person.cn.demotestone.thread.aqs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.aqs
 * @updateUser
 * @date 14:28 2021/1/7
 */
public class ProducerAndConsumer {
    private static final PersonalNonReentrantLock lock = new PersonalNonReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();
    private static Queue<String> queue = new LinkedBlockingQueue<>();
    private static final int queueSize = 10;

    public static void main(String[] args) throws InterruptedException {
     Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    //队列满
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (queue.size() != queueSize) {
                            //不满，添加数据
                            queue.add("ele");
                            System.out.println(Thread.currentThread().getName() + "：添加一个元素");
                            //唤醒消费者
                            notEmpty.signal();
                        } else {
                            try {
                                notFull.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        };
     Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (true) {
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (queue.size() != 0) {
                            //取数据
                            String ele = queue.poll();
                            System.out.println(Thread.currentThread().getName() + "：取出元素：" + ele);
                            notFull.signal();
                        } else {
                            try {
                                notEmpty.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                } finally {
                    lock.unlock();
                }
            }
        };
     Thread producer = new Thread(runnable1,"生产者");
     Thread consumer1= new Thread(runnable2,"消费者1");
     Thread consumer2= new Thread(runnable2,"消费者2");
     producer.start();
     consumer1.start();
     consumer2.start();

    }
}
