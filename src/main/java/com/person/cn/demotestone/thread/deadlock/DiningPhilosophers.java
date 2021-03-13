package com.person.cn.demotestone.thread.deadlock;

/**
 * @author ym.y
 * @description 哲学家就餐问题
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 11:49 2020/12/29
 */
public class DiningPhilosophers {

    public static class Philosopher implements Runnable {
        private Object leftChopsticks;
        private Object rightChopsticks;

        public Philosopher(Object leftChopsticks, Object rightChopsticks) {
            this.leftChopsticks = leftChopsticks;
            this.rightChopsticks = rightChopsticks;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    doAction("正在思考...");
                    synchronized (leftChopsticks) {
                        doAction("拿起左边的筷子！");
                        synchronized (rightChopsticks) {
                            //吃饭
                            doAction("拿起右边的筷子，开始吃饭！");
                            //放下右边的筷子
                            doAction("放下右边的筷子！");
                        }
                        //放下左边的筷子
                        doAction("放下左边的筷子！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + action);
            Thread.sleep((long) Math.random() * 10);
        }
    }


    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[philosophers.length];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

        //会导致死锁
//        for (int i = 0; i < philosophers.length; i++) {
//            Object leftChopsticks = chopsticks[i];
//            Object rightChopsticks = chopsticks[(i + 1) % chopsticks.length];
//            philosophers[i] = new Philosopher(leftChopsticks, rightChopsticks);
//            new Thread(philosophers[i], "哲学家" + (i + 1) + "号").start();
//        }

        //解决方法1： 改变获取锁的顺序,最后一位哲学家先拿右边的筷子，其他的先拿左边的筷子
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopsticks = chopsticks[i];
            Object rightChopsticks = chopsticks[(i + 1) % chopsticks.length];
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightChopsticks, leftChopsticks);
            } else {
                philosophers[i] = new Philosopher(leftChopsticks, rightChopsticks);
            }
            new  Thread(philosophers[i],"哲学家" + (i + 1) + "号").start();
        }
    }
}
