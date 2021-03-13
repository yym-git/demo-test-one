package com.person.cn.demotestone.thread.deadlock;

import java.util.Random;

/**
 * @author ym.y
 * @description 演示活锁以及活锁的解决方式
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 13:10 2020/12/29
 */
public class LiveLock {

    static class Spoon {
        private Dinner owner;

        public synchronized void use() {
            System.out.printf("%s:我正在吃饭!\n", owner.name);
        }

        public Spoon(Dinner owner) {
            this.owner = owner;
        }

        public Dinner getOwner() {
            return owner;
        }

        public void setOwner(Dinner owner) {
            this.owner = owner;
        }
    }

    static class Dinner {
        private String name;
        private boolean isHungry;

        public Dinner(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public void eatWith(Spoon spoon, Dinner spouse) {
            //判断自己是否饥饿
            while (isHungry) {
                //自己是否拿到勺子
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                //判断对方是否饥饿
                Random random = new Random();
                if (spouse.isHungry
                        //添加一下代码可以解决活锁
                        &&random.nextInt(10)<9) {
                    System.out.println(name + ":你先吃饭" + spouse.name);
                    spoon.setOwner(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.println(name + ":已经吃完!");
                spoon.setOwner(spouse);
            }
        }

    }

    public static void main(String[] args) {
        Dinner husband = new Dinner("牛郎");
        Dinner wife = new Dinner("织女");
        Spoon spoon = new Spoon(husband);
        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}
