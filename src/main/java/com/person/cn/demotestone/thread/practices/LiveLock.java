package com.person.cn.demotestone.thread.practices;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.practices
 * @updateUser
 * @date 9:43 2020/12/30
 */
public class LiveLock {

    //就餐者
    static class Diner {
        //就餐人名字
        private String name;
        //是否饥饿
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            this.isHungry = true;
        }

        /**
         * @description 开始就餐
         * @author ym.y
         * @updateUser
         * @date 9:52 2020/12/30
         */
        public void eatWithSpoon(Spoon spoon, Diner diner) {
            //自己是否饥饿
            while (isHungry) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //判断餐具是否被自己持有
                if (spoon.diner != this) {
                    //没有拿到餐具休眠
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                //以下代码破坏相互让资源
                Random random = new Random();
                int  num  = random.nextInt(10);
                //拿到餐具，判断对方是否饥饿
                if (diner.isHungry&& num< 9) {
                    //把餐具的使用权给对方
                    System.out.println(name + ":" + diner.name + ",你先吃吧！");
                    spoon.diner = diner;
                    continue;
                }
                spoon.use();
                isHungry = false;
                System.out.println(name + "我已经吃完了！");
                //将餐具的使用权给对方
                spoon.diner = diner;
            }
        }
    }

    //就餐餐具
    static class Spoon {
        //餐具的持有者
        private Diner diner;

        public Spoon(Diner diner) {
            this.diner = diner;
        }

        private synchronized void use() {
            System.out.println(diner.name + "我正在吃饭！");
        }
    }

    public static void main(String[] args) {
        Diner husband = new Diner("牛郎");
        Diner wife = new Diner("织女");
        Spoon spoon = new Spoon(wife);
        new  Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWithSpoon(spoon,husband);
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWithSpoon(spoon,wife);
            }
        }).start();

    }
}
