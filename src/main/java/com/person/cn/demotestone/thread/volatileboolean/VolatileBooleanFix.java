package com.person.cn.demotestone.thread.volatileboolean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ym.y
 * @description 使用Interrupt改进WrongVolatileBoolean的无限阻塞问题
 * @package com.person.cn.demotestone.thread.volatileboolean
 * @updateUser
 * @date 18:25 2020/12/25
 */
public class VolatileBooleanFix {

    public static void main(String[] args) throws InterruptedException {
        VolatileBooleanFix fix = new VolatileBooleanFix();
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Producer producer = fix.new Producer(queue);
        Thread th = new Thread(producer);
        th.start();
        Thread.sleep(1000);
        Consumer consumer = fix.new Consumer(queue);
       while (!consumer.needMoreNums()) {
            System.out.println(consumer.queue.take()+"被消费");
            Thread.sleep(1000);
        }
        System.out.println("不需要更多的数据");
        //设置生产者线程状态为中断
        th.interrupt();
    }

    //生产者
    class Producer implements Runnable {
        public BlockingQueue<Integer> queue = null;
        public volatile boolean cancel = false;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int a = 0;
            try {
                while (a <= 100000 && !Thread.currentThread().isInterrupted()) {
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

        public boolean needMoreNums() throws InterruptedException {
            while(queue.peek()> 10){
                return true;
            }
            return false;
        }
    }

}
