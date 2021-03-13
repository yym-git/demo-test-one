package com.person.cn.demotestone.thread.flowcontroller;

import java.util.concurrent.CountDownLatch;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.flowcontroller
 * @updateUser
 * @date 14:34 2021/2/26
 */
public class CountDownLatchDemo4 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "被灭了！");
                count.countDown();
            }, CountryEnum.forEach(i).getDesc()).start();
        }
        count.await();
        System.out.println("秦一统六国了");
    }
}
