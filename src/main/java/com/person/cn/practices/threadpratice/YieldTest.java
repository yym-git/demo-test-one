package com.person.cn.practices.threadpratice;

/**
 * @author ym.y
 * @description yield()方法让出CPU持有的时间片，进入CPU的重新调度，意味着调用了yield()方法的线程有
 * 可能会重新获取到CPU的执行权。
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 16:29 2021/3/20
 */
public class YieldTest implements Runnable {
    public YieldTest() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if(i % 5 ==0){
                System.out.println(Thread.currentThread().getName()+" yield cpu...");
                //当前线程让出CPU执行权，进入下一轮的CPU调度
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+" is over！");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
