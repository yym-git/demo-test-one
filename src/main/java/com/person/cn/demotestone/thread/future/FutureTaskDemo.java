package com.person.cn.demotestone.thread.future;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.future
 * @updateUser
 * @date 11:14 2021/1/4
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        TaskDemo taskDemo = new TaskDemo();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(taskDemo);
//        new  Thread(integerFutureTask).start();
        ExecutorService service  = Executors.newFixedThreadPool(1);
        service.submit(integerFutureTask);

        try {
            System.out.println("计算结果"+integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class TaskDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i <= 100; i++)
            sum += i;
        return sum;
    }
}
