package com.person.cn.demotestone.thread.callable.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.callable.com
 * @updateUser
 * @date 13:46 2021/2/27
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        //如果两个线程使用相同的futureTask只会打印一次 "实现call方法"
        //使用不同的futureTask会打印多次
        new Thread(futureTask,"AA").start();
        new Thread(futureTask2,"BB").start();

        //获取线程执行返回的结果
        while(!futureTask.isDone()){
            int  result  = futureTask.get();
            System.out.println("线程返回结果："+result);
        }
    }
}

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Integer result  = 1024;
        System.out.println("实现call方法");
//        Thread.sleep(5000);
        return result;
    }
}
