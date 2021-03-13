package com.person.cn.demotestone.thread.threadstate;

/**
 * @author ym.y
 * @description WAITING TIMED_WAITING BLOCKED
 * @package com.person.cn.demotestone.thread.threadstate
 * @updateUser
 * @date 15:41 2020/12/26
 */
public class ThreadWaitingTimeWaitingBlock implements Runnable {

    @Override
    public void run() {
        test();
    }


    public synchronized void test() {
        try {
            Thread.sleep(3000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadWaitingTimeWaitingBlock wtb = new ThreadWaitingTimeWaitingBlock();
        Thread thread1 = new Thread(wtb);
        thread1.start();
        Thread thread2 = new Thread(wtb);
        thread2.start();
        Thread.sleep(10);
        System.out.println("线程1状态："+thread1.getState());
        System.out.println("线程2状态："+thread2.getState());

        //演示waiting状态
        Thread.sleep(1300);
        System.out.println("线程1状态："+thread1.getState());

    }
}
