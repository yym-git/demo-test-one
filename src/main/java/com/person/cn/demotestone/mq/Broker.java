package com.person.cn.demotestone.mq;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author ym.y
 * @description 消息处理中心
 * @package com.person.cn.demotestone.mq
 * @updateUser
 * @date 10:20 2020/12/22
 */
public class Broker {
    //队列能存储消息的最大数量
    private final static int MAX_SIZE = 3;
    //保存消息的队列
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    /**
     * @description 生产消息
     * @author ym.y
     * @updateUser
     * @date 10:24 2020/12/22
     */
    public static void produce(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息：" + msg + ",当前暂存的消息数量是:" + messageQueue.size());
        } else {
            System.out.println("消息中心暂存消息达到负荷，不能继续放消息！");
        }
    }


    /**
     * @description 消费消息
     * @author ym.y
     * @updateUser
     * @date 10:28 2020/12/22
     */
    public static String consume() {
        String msg = messageQueue.poll();
        if (msg != null) {
            System.out.println("已经消费消息：" + msg + ",当前暂存的消息数量为：" + messageQueue.size());
        } else {
            System.out.println("没有可以消费的消息！");
        }
        System.out.println("=================================");
        return msg;
    }
}
