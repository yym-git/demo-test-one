package com.person.cn.demotestone.thread.practices;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 10:07 2021/1/7
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        NumP numP = new NumP();
        new  Thread(numP,"偶數").start();
        Thread.sleep(10);
        new  Thread(numP,"奇数").start();
    }
}

class NumP implements Runnable {
    private volatile int count = 0;
    private Object obj = new Object();

    @Override
    public void run() {
        while (count <= 100) {
            synchronized (obj){
                System.out.println(Thread.currentThread().getName()+":"+(count++));
                obj.notify();
                if(count<=100){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}