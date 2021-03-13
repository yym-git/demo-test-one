package com.person.cn.demotestone.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author ym.y
 * @description 实现自己的AQS
 * @package com.person.cn.demotestone.thread.aqs
 * @updateUser
 * @date 11:40 2021/1/3
 */
public class PersonalAQS {

    private final Sync sync = new Sync();

    public void await() {
        sync.acquireShared(0);
    }

    public void signal() {
        sync.releaseShared(0);
    }

    static class Sync extends AbstractQueuedSynchronizer {
        /**
         * @description 尝试获取锁
         * @author ym.y
         * @updateUser
         * @date 12:01 2021/1/3
         */
        @Override
        protected int tryAcquireShared(int arg) {
            return (getState() == 1) ? 1 : -1;
        }

        /**
         * @description 释放锁
         * @author ym.y
         * @updateUser
         * @date 12:01 2021/1/3
         */
        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PersonalAQS personalAQS = new PersonalAQS();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "尝试获取锁，获取失败等待....");
                    personalAQS.await();
                    System.out.println(Thread.currentThread().getName()+"放行,继续执行...........");
                }
            }).start();
        }

        Thread.sleep(5000);
        //放行
        personalAQS.signal();
    }
}
