package com.person.cn.demotestone.thread.productandconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ym.y
 * @description 生产者消费者模式：阻塞队列(周阳)
 * @package com.person.cn.demotestone.thread.productandconsumer
 * @updateUser
 * @date 11:48 2021/2/27
 */
public class ProductAndConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        Resources resources = new Resources(new ArrayBlockingQueue<String>(3));
        new Thread(() -> {
            try {
                System.out.println("生产线程启动");
                System.out.println("\n");
                resources.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者").start();

        new Thread(() -> {
            try {
                System.out.println("消费线程启动");
                System.out.println("\n");
                resources.myConsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();

        Thread.sleep(5000);
        System.out.println("停止运作");
        resources.stop();

    }
}

class Resources {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public Resources(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass());
    }

    /**
     * @description 生产方法
     * @author ym.y
     * @updateUser
     * @date 11:52 2021/2/27
     */
    public void myProd() throws InterruptedException {
        String data = null;
        boolean result;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            result = blockingQueue.offer(data, 2l, TimeUnit.SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "成功！");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "失败！");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t生产线程停止flag=false");
    }


    /**
     * @description 消费方法
     * @author ym.y
     * @updateUser
     * @date 12:04 2021/2/27
     */
    public void myConsume() throws InterruptedException {
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equals("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t2秒钟没有获取元素，消费失败");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列成功:" + result);
        }
    }

    public void stop() {
        flag = false;
    }
}
