package com.person.cn.demotestone.thread.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.queue.blockingqueue
 * @updateUser
 * @date 22:17 2021/2/26
 */
public class TestArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        //添加元素 超出范围抛异常
//        queue.add("1");
//        queue.add("1");
//        queue.add("1");
//        queue.add("1");

        //添加元素 队列满返回false
//        System.out.println(queue.offer("1"));
//        System.out.println(queue.offer("1"));
//        System.out.println(queue.offer("1"));
//        System.out.println(queue.offer("1"));

        //队列为空抛出异常
        System.out.println(queue.element());
//        System.out.println(queue.element());
//        System.out.println(queue.element());
//        System.out.println(queue.element());
//        System.out.println(queue.element());

//队列空返回null
        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());

        //put()超出队列长度，阻塞
        queue.put("11");
        queue.put("11");
        queue.put("11");
        queue.put("11");

    }
}
