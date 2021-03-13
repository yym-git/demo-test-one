package com.person.cn.demotestone.thread.queue.syhc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.queue.syhc
 * @updateUser
 * @date 15:44 2021/2/26
 */
public class SynchronizedQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new  Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put1");
                blockingQueue.put("1");
                blockingQueue.element();
                System.out.println(Thread.currentThread().getName()+" put2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+" put3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new  Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());

                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());

                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
