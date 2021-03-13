package com.person.cn.demotestone.thread.threadstate;

/**
 * @author ym.y
 * @description 展示线程的NEW RUNNABLE TERMINATED状态
 * @package com.person.cn.demotestone.thread.threadstate
 * @updateUser
 * @date 15:31 2020/12/26
 */
public class ThreadNewRunnableTerminated implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadNewRunnableTerminated());
        System.out.println("1:"+thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2:"+thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3:"+thread.getState());
    }
}
