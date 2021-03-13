package com.person.cn.demotestone.mq;

import javax.naming.ldap.SortKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.mq
 * @updateUser
 * @date 10:49 2020/12/22
 */
public class MqClient {
    /**
     * @description 客户端生产消息方法
     * @author ym.y
     * @updateUser
     * @date 10:49 2020/12/22
     */
    public static void produce(String message) {

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(message);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 客户端消费消息方法
     * @author ym.y
     * @updateUser
     * @date 10:54 2020/12/22
     */
    public static String consume() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //先向消息队列发送"CONSUME"表示消费
            out.println("CONSUME");
            out.flush();
            //再从消息队列获取一条消息
            String message = in.readLine();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
