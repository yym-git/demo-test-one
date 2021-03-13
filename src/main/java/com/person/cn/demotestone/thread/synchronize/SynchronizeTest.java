package com.person.cn.demotestone.thread.synchronize;

/**
 * @author ym.y
 * @description 两个线程同时访问一个对象的同步方法
 * @package com.person.cn.demotestone.thread.synchronize
 * @updateUser
 * @date 10:22 2020/12/25
 */
public class SynchronizeTest  implements Runnable{
    private  static SynchronizeTest syn = new SynchronizeTest();
    @Override
    public void run() {
        info();
    }

    public synchronized  void  info(){
        System.out.println("线程："+Thread.currentThread().getName()+",开始执行");
        System.out.println("哈哈");
        System.out.println("线程："+Thread.currentThread().getName()+",执行结束");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws InterruptedException {
     Thread th1  = new Thread(syn);
     Thread th2  = new Thread(syn);
     th1.start();
     th2.start();
     th1.join();
     th2.join();
    }
}
