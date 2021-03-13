package com.person.cn.demotestone.thread.practices;

/**
 * @author ym.y
 * @description 两个线程交替打印100以内的奇偶数，用wait和notify
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 18:59 2020/12/26
 */
public class Test2 {

    private static int count;
    private static Object obj = new Object();

    public static void main(String[] args) {
        Thread th1 = new Thread(new Process(),"偶数");
        Thread th2 = new Thread(new Process(),"奇数");
        th1.start();
        th2.start();
    }

    static class Process implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    //唤醒等待的线程
                    obj.notify();
                    if (count <= 100) {
                        try {
                            //当前线程执行完成后，进入阻塞，等着下个线程唤醒
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
