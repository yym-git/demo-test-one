package com.person.cn.demotestone.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.future
 * @updateUser
 * @date 15:06 2021/1/3
 */
public class FutureDemo3 {
    public static void main(String[] args) throws InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Future<String> future = service.submit(new TaskCallable());
            futures.add(future);
        }
        service.shutdown();
        Thread.sleep(2000);
        for (int i = 0; i < futures.size(); i++) {
            Future<String> future = futures.get(i);
            try {
                //future.isDone()线程是否已经执行完成，即使抛出异常了也返回true
                System.out.println("执行状态："+future.isDone());
                System.out.println("线程返回结果："+future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("线程开始执行");
            throw new IllegalArgumentException("Callable抛出异常！");
        }
    }
}


