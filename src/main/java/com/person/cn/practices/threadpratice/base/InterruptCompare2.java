package com.person.cn.practices.threadpratice.base;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 17:22 2021/3/20
 */
public class InterruptCompare2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()){
                    System.out.println(Thread.currentThread().getName()+"线程没有被中断");
                }
            }
        },"threadOne");

        threadOne.start();
        Thread.sleep(500);
        threadOne.interrupt();
        threadOne.join();
        System.out.println("threadOne的线程状态："+threadOne.isInterrupted());

    }
}
