package com.person.cn.demotestone.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description 最大线程数为Integer.MAX_VALUE也会导致OOM
 * 自动回收多余线程
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 15:52 2020/12/29
 */
public class CacheThreadTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int  i  = 0; i< 200 ; i++){
            service.execute(new Task());
        }
        service.shutdown();
    }
}