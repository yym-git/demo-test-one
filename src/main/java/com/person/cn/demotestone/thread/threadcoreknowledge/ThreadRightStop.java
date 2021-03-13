package com.person.cn.demotestone.thread.threadcoreknowledge;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 14:12 2020/12/25
 */
public class ThreadRightStop implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadRightStop());
        thread.start();
        Thread.sleep(2000);
        //将线程标记为中断状态
        thread.interrupt();
    }

    @Override
    public void run() {
        int num = 0;
        while(!(Thread.currentThread().isInterrupted())&&num <= Integer.MAX_VALUE/2 ){
            if(num % 5 == 0){
                System.out.println(num+"是5的倍数");
            }
            num++;
        }
        System.out.println("运行结束");
    }
}
