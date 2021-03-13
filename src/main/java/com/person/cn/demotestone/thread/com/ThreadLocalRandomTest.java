package com.person.cn.demotestone.thread.com;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 12:552020/11/17
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        ThreadLocalRandom localRandom =ThreadLocalRandom.current();
        for(int i =0; i < 10; ++i){
            System.out.println(localRandom.nextInt(5));
        }
    }
}
