package com.person.cn.demotestone.thread.condition.test2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition.test2
 * @updateUser
 * @date 14:46 2021/1/12
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        MyService myService = new MyService();
        Producer producer = new Producer(myService);
        Consumer consumer = new Consumer(myService);
        new  Thread(producer).start();
        new  Thread(consumer).start();
    }
}
