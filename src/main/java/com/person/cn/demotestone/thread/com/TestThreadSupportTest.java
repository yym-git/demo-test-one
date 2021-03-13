package com.person.cn.demotestone.thread.com;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ym.y   调用了LockSupport.park()方法的线程会因为线程的中断而返回
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 10:192020/11/18
 */
public class TestThreadSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                //挂起子线程
                while(!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("child thread begin unPark!");
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread  begin unPark!");
        Thread.sleep(2000);
        thread.interrupt();
        LockSupport.park(thread);
    }
}
