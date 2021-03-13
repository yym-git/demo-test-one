package com.person.cn.demotestone.thread.practices;

/**
 * @author ym.y
 * @description join的等价方法
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 11:59 2020/12/27
 */
public class JoinPrincipe {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕！");
            }
        });
        thread.start();
        System.out.println(Thread.currentThread().getName()+"等待子线程执行完毕！");
//        thread.join();
        synchronized (thread){
            thread.wait();
        }
        System.out.println("所有线程执行完毕！");

    }
}
