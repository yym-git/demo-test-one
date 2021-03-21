package com.person.cn.practices;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices
 * @updateUser
 * @date 16:22 2021/3/21
 */
public class PrintNumber {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer p = new IntConsumer();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
