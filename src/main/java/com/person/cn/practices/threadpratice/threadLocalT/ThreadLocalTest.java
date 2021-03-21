package com.person.cn.practices.threadpratice.threadLocalT;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadpratice.threadLocalT
 * @updateUser
 * @date 17:56 2021/3/20
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str) {
        //打印本地线程的localVariable值
        System.out.println(str + ":" + localVariable.get());
        //清除当前线程的本地内存中的localVariable
        localVariable.remove();
    }

    public static void main(String[] args) {
        new  Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("我是线程One");
                print("threadOne");
                System.out.println("线程一："+localVariable.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("我是线程Two");
                print("threadTwo");
                System.out.println("线程二："+localVariable.get());
            }
        }).start();
    }
}
