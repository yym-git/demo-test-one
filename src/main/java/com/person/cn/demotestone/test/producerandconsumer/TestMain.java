package com.person.cn.demotestone.test.producerandconsumer;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test.producerandconsumer
 * @updateUser
 * @date 20:22 2021/1/12
 */
public class TestMain {
    public static void main(String[] args) {
        MyService myService = new MyService();
        Producer producer = new Producer(myService);
        Consumer consumer = new Consumer(myService);
        new Thread(producer,"生产者").start();
        new Thread(consumer,"消费者").start();
    }
}
