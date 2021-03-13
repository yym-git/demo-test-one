package com.person.cn.demotestone.thread.lock.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author ym.y
 * @description 原子数组的使用方法
 * @package com.person.cn.demotestone.thread.lock.atomic
 * @updateUser
 * @date 11:39 2020/12/31
 */
public class AtomicArrayDemo {
    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(1000);
        Increment increment = new Increment(array);
        Decrement decrement = new Decrement(array);
        Thread[] threadsDecrement = new Thread[100];
        Thread[] threadsIncrement = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threadsDecrement[i] = new Thread(decrement);
            threadsIncrement[i] = new Thread(increment);
            threadsDecrement[i].start();
            threadsIncrement[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                threadsIncrement[i].join();
                threadsDecrement[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < array.length(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("运行结束！");
    }
}

//每个数组自减1
class Decrement implements Runnable {
    private AtomicIntegerArray atomicIntegerArray;

    public Decrement(AtomicIntegerArray atomicIntegerArray) {
        this.atomicIntegerArray = atomicIntegerArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            atomicIntegerArray.getAndDecrement(i);
        }
    }
}


//每个数组自增1
class Increment implements Runnable {
    private AtomicIntegerArray atomicIntegerArray;

    public Increment(AtomicIntegerArray atomicIntegerArray) {
        this.atomicIntegerArray = atomicIntegerArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            atomicIntegerArray.getAndIncrement(i);
        }
    }
}