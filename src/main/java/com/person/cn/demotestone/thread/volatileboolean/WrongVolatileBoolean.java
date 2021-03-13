package com.person.cn.demotestone.thread.volatileboolean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ym.y
 * @description volatile boolean的存在的问题
 * 生产者消费者模式：当生产者的速度>消费者速度时，队列满了，会无限阻塞，不能及时唤醒
 * @package com.person.cn.demotestone.thread.volatilecom
 * @updateUser
 * @date 17:12 2020/12/25
 */
public class WrongVolatileBoolean {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(queue);
        Thread thread = new Thread(producer);
        thread.start();
        Thread.sleep(5000);
        Consumer consumer = new Consumer(queue);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.queue.take() + "被消费");
            Thread.sleep(1000);
        }
        System.out.println("消费者不需要更多数据");
        producer.cancel = true;
        System.out.println("设置标志成功：" + producer.cancel);
    }

}


//生产者
class Producer implements Runnable {
    public BlockingQueue<Integer> queue = null;
    public static volatile boolean cancel = false;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int a = 0;
        try {
            while (a <= 100000 && !cancel) {
                if (a % 2 == 0) {
                    //队列满的时候会阻塞
                    queue.put(a);
                    System.out.println(a + "是2的倍数");
                }
                a++;
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束生产!");
        }
    }
}

//消费者
class Consumer {
    public BlockingQueue<Integer> queue = null;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return true;
        }
        return false;
    }
}
