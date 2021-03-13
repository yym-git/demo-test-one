package com.person.cn.demotestone.test;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 21:09 2021/3/2
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        new  Thread(testDemo,"AA").start();
        new  Thread(testDemo,"BB").start();
        new  Thread(testDemo,"CC").start();
        new  Thread(testDemo,"DD").start();
//
//        System.out.println("========开始=======");
//        System.out.println("========结束=======");
//        LockSupport.park();
    }
}

class TestDemo implements Runnable{

    @Override
    public void run() {
        LockSupport.unpark(Thread.currentThread());
        System.out.println(Thread.currentThread().getName());
        LockSupport.park();
    }
}
