package com.person.cn.demotestone.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description SingleThreadExecutor同样使用LinkedBlockingQueue无界队列
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 15:44 2020/12/29
 */
public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i = 0; i< 20; i++){
            service.execute(new Task());
        }
        //拒绝新的任务，处理阻塞队列中的任务
        service.shutdown();
        //拒绝新任务，返回阻塞队列中的任务，停止正在执行的任务
        service.shutdownNow();
    }
}

class Task implements  Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
