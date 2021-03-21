package com.person.cn.practices.threadpratice.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * 线程内调用sleep()方会阻塞该线程，让出CPU的执行权，不参与CPU的调度，但是不会释放该线程持有的锁，当休眠之间过期后，进入就绪
 * 状态，参与CPU的线程调度。
 * @package com.person.cn.practices.threadmian
 * @updateUser
 * @date 23:33 2021/3/19
 */
public class SleepTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try{
                    System.out.println("执行线程一");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("线程一休眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try{
                    System.out.println("执行线程二");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("线程二休眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
