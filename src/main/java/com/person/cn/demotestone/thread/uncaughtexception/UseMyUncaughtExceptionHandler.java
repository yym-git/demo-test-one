package com.person.cn.demotestone.thread.uncaughtexception;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.uncaughtexception
 * @updateUser
 * @date 21:20 2020/12/27
 */
public class UseMyUncaughtExceptionHandler implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        new Thread(new UseMyUncaughtExceptionHandler(), "线程1").start();
        new Thread(new UseMyUncaughtExceptionHandler(), "线程2").start();
        new Thread(new UseMyUncaughtExceptionHandler(), "线程3").start();
        new Thread(new UseMyUncaughtExceptionHandler(), "线程4").start();


    }
}
