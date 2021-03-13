package com.person.cn.demotestone.thread.threadobjectclasscommon;

import java.util.LinkedList;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadobjectclasscommon
 * @updateUser
 * @date 18:12 2020/12/26
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> storage = new LinkedList<>();
        Thread producer = new Thread(new Producer(storage));
        Thread.sleep(100);
        Thread consumer = new Thread(new Consumer(storage));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private LinkedList<Integer> storage;

    public Producer(LinkedList<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            while (storage.size() == 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add((int) (Math.random() * 100));
            System.out.println("添加一个数，现有库存为：" + storage.size());
            notify();
        }
    }
}


class Consumer implements Runnable {
    private LinkedList<Integer> storage;

    public Consumer(LinkedList<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(storage.size());
            while (storage.size() == 0) {
                try {
                   wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("取出数据" + storage.poll() + ",仓库数据：" + storage.size());
            notify();
        }
    }
}
