package com.person.cn.demotestone.thread.lock.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ym.y
 * @description 将普通变量升级为原子变量
 * @package com.person.cn.demotestone.thread.lock.atomic
 * @updateUser
 * @date 12:48 2020/12/31
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {
    static Candidate tom;
    static Candidate peter;

    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            peter.score++;
            scoreUpdater.getAndIncrement(tom);
        }
    }

    public static class Candidate {
        //保证线程的可见性，并不保证线程的原子性，不能是static类
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通的变量：" + peter.score);
        System.out.println("升级的变量：" + tom.score);

    }
}

