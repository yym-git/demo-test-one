package com.person.cn.demotestone.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.future
 * @updateUser
 * @date 14:40 2021/1/3
 */
public class FutureDemo2 {
    public static void main(String[] args) throws InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            final int num = i;
            //提交之后就开始执行了
            Future<String> future = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(3000);
                    String str = "future_" + num;
                    System.out.println("进入线程...");
                    return str;
                }
            });
            futures.add(future);
        }
        executor.shutdown();
        for (int i = 0; i < futures.size(); i++) {
            try {
                System.out.println("线程返回结果：" + futures.get(i).get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
