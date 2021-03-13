package com.person.cn.demotestone.thread.threadcoreknowledge;

/**
 * @author ym.y
 * @description 线程阻塞状态也能响应中断，每次循环中进行阻塞，休眠时捕获异常
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 14:25 2020/12/25
 */
public class ThreadStopWithSleep3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 2000000 && !Thread.currentThread().isInterrupted()) {
                System.out.println("当前线程是否被标记为中断："+Thread.currentThread().isInterrupted());
                if (num % 2 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
