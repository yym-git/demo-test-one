package com.person.cn.practices.threadpratice.base;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 18:48 2021/3/19
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("one thread begin");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("one thread over");
            }
        }, "A");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("two thread begin");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("two thread over");
            }
        }, "B");

        threadA.start();
        threadB.start();
        System.out.println("等待所有的子线程结束");
        threadA.join();
        threadB.join();
        System.out.println("所有子线程运行结束");
    }
}
