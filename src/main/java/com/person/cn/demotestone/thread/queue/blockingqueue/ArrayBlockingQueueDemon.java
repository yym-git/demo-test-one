package com.person.cn.demotestone.thread.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.queue.blockingqueue
 * @updateUser
 * @date 13:20 2021/1/2
 */
public class ArrayBlockingQueueDemon {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Interviewer interviewer = new Interviewer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(interviewer).start();
        new Thread(consumer).start();


    }

}

class Interviewer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public Interviewer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        blockingQueue.add("");
    }

    @Override
    public void run() {
        System.out.println("来了10个面试者");
        for (int i = 0; i < 10; i++) {
            String candidate = "Candidate_" + i;
            try {
                blockingQueue.put(candidate);
                System.out.println("安排好了" + candidate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //结束标志
        try {
            blockingQueue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                String msg = queue.take();
                if ("stop".equals(msg)) {
                    System.out.println("所有面试者面试结束！");
                    break;
                } else {
                    System.out.println("轮到了面试者" + msg);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}