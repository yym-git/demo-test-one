package com.person.cn.demotestone.thread.threadobjectclasscommon;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadobjectclasscommon
 * @updateUser
 * @date 16:30 2020/12/26
 */
public class WaitNotifyAll {
    static Object obj = new Object();

    static class TestA implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("线程1获取到锁");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程1执行结束！");
            }
        }
    }

    static class TestB implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("线程2获取到锁");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2执行完毕！");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new WaitNotifyAll.TestA());
        Thread th2 = new Thread(new WaitNotifyAll.TestB());
        th1.start();
        th2.start();
        Thread.sleep(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("线程3获取到锁");
                    obj.notifyAll();
                    System.out.println("线程3执行结束");
                }
            }
        }).start();
    }
}
