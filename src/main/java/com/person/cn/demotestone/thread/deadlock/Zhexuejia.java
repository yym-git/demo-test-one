package com.person.cn.demotestone.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 11:42 2021/1/7
 */
public class Zhexuejia {
    public static void main(String[] args) {
        Philosopher2[] philosopher2s = new Philosopher2[5];
        Object[] objects = new Object[philosopher2s.length];
        for (int i = 0; i < philosopher2s.length; i++) {
            objects[i] = new Object();
        }
        for (int i = 0; i < philosopher2s.length; i++) {
            Object leftChopsticks = objects[i];
            Object rightChopsticks = objects[(i + 1) % (philosopher2s.length)];
            if (i == philosopher2s.length - 1) {
                philosopher2s[i] = new Philosopher2(rightChopsticks, leftChopsticks);
            } else {
                philosopher2s[i] = new Philosopher2(leftChopsticks, rightChopsticks);
            }
            new Thread(philosopher2s[i], "哲学家" + (i + 1) + "号").start();
        }
    }
}

class Philosopher2 implements Runnable {
    private Object leftChopsticks;
    private Object rightChopsticks;

    public Philosopher2(Object leftChopsticks, Object rightChopsticks) {
        this.leftChopsticks = leftChopsticks;
        this.rightChopsticks = rightChopsticks;
    }

    @Override
    public void run() {
        while (true) {
            try {
                doAction("正在思考");
                synchronized (leftChopsticks) {
                    doAction("拿起左边的筷子");
                    synchronized (rightChopsticks) {
                        doAction("拿起右边的筷子，开始吃饭");
                        doAction("放下右边的筷子");
                    }
                    doAction("放下左边的筷子");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doAction(String str) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "：" + str);
        TimeUnit.SECONDS.sleep((long) Math.random() * 10);
    }
}
