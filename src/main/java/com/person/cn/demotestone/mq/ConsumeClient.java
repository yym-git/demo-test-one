package com.person.cn.demotestone.mq;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.mq
 * @updateUser
 * @date 11:01 2020/12/22
 */
public class ConsumeClient {
    public static void main(String[] args) {
        MqClient client = new MqClient();
        String str = client.consume();
        System.out.println("获取的消息是：" + str);
    }
}
