package com.person.cn.demotestone.thread.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @author ym.y
 * @description 指令重排序的演示
 * @package com.person.cn.demotestone.thread.jmm
 * @updateUser
 * @date 12:19 2020/12/28
 */
public class OutOfOrderExecution {
    private static int x, y, a, b;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            two.start();
            countDownLatch.countDown();
            one.join();
            two.join();
            String result = "第" + i + "次（" + x + "," + y + ")";
            if (x == 0 && y == 1) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
            //可能出现的情况
            // x=1,y=1
            //x=0,y=1
            //x=1,y=0

        }
    }
}
