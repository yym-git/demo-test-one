package com.person.cn.demotestone.thread.threadcoreknowledge;

/**
 * @author ym.y
 * @description 线程阻塞状态也能响应中断，每次循环中进行阻塞
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 14:25 2020/12/25
 */
public class ThreadStopWithSleep2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable =()->{
            int  num  = 0;
            try {
                while(num <= 2000000){
                    if(num % 2 == 0){
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
