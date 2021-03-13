package com.person.cn.demotestone.thread.future;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.future
 * @updateUser
 * @date 14:09 2021/1/3
 */
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<Integer> callable = () -> {
            Thread.sleep(3000);
            return new Random().nextInt();
        };
        Future<Integer> future = service.submit(callable);
        try {
            System.out.println("线程执行返回结果："+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();

    }
}
