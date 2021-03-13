package com.person.cn.demotestone.thread.threadobjectclasscommon;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadobjectclasscommon
 * @updateUser
 * @date 16:22 2020/12/26
 */
public class WaitTest {
    static Object obj = new Object();

    static class ClassA implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                try {
                    //释放锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"执行结束");
            }
        }
    }

    static class ClassB implements Runnable {

        @Override
        public void run() {
            synchronized (obj){
                obj.notify();
                System.out.println(Thread.currentThread().getName()+"执行完成！");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1  = new Thread(new WaitTest.ClassA());
        Thread thread2 = new Thread(new  WaitTest.ClassB());
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}


