package com.person.cn.demotestone.mq;

import com.person.cn.demotestone.designmodel.command.undo.CalculatorForm;

import javax.annotation.security.RunAs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.mq
 * @updateUser
 * @date 10:33 2020/12/22
 */
public class BrokerServer implements Runnable {
    //监听的端口号
    public static int SERVICE_PORT = 9999;
    private final Socket socket;

    public BrokerServer(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            while (true) {
                String str = in.readLine();
                if (str == null) {
                    continue;
                }
                System.out.println("接收到原始数据：" + str);
                if (str.equals("CONSUME")) {
                    //消费者
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                } else {
                    //生产者
                    Broker.produce(str);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVICE_PORT);
        while (true) {
            BrokerServer brokerServer = new BrokerServer(server.accept());
            new Thread(brokerServer).start();
        }
    }
}
