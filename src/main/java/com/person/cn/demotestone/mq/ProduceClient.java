package com.person.cn.demotestone.mq;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.mq
 * @updateUser
 * @date 11:00 2020/12/22
 */
public class ProduceClient {
    public static void main(String[] args) {
        MqClient.produce("Hello World");
    }
}
