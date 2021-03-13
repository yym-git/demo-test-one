package com.person.cn.demotestone.thread.threadobjectclasscommon;

import java.util.LinkedList;

/**
 * @author ym.y
 * @description 生产者消费者模式
 * @package com.person.cn.demotestone.thread.threadobjectclasscommon
 * @updateUser
 * @date 17:06 2020/12/26
 */
public class ProducerAndConsumer {

    //生产者
    class Producer implements Runnable {
        private Element element;

        public Producer(Element element) {
            this.element = element;
        }

        @Override
        public void run() {
            for(int i =0; i< 100;i++){
                element.put();
            }
        }
    }

    class Consumer implements Runnable {
        private Element element;

        public Consumer(Element element) {
            this.element = element;
        }

        @Override
        public void run() {
            for(int i =0; i< 100;i++){
                element.take();
            }
        }
    }


    class Element {
        private int maxSize;
        private LinkedList<Integer> storage;

        public Element() {
            this.maxSize = 10;
            this.storage = new LinkedList<>();
        }
        /**
         * @description 添加元素
         * @author ym.y
         * @updateUser
         * @date 17:47 2020/12/26
         */
        public synchronized void put() {
            while (storage.size() == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add((int) (Math.random() * 100));
            System.out.println("仓库有" + storage.size() + "个产品");
            notify();
        }


        /**
         * @description 取数据
         * @author ym.y
         * @updateUser
         * @date 17:50 2020/12/26
         */
        public synchronized void take() {
            while (storage.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("拿到了数据：" + storage.poll() + "，现在仓库的个数：" + storage.size());
            notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        Element element = pc.new Element();
        Producer producer = pc.new Producer(element);
        Consumer consumer = pc.new Consumer(element);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

