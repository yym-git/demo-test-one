package com.person.cn.practices.threadpratice.threadLocalT;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadpratice.threadLocalT
 * @updateUser
 * @date 18:15 2021/3/20
 */
public class InheritableThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("main线程设置的值");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程："+local.get());
            }
        }).start();
        System.out.println("主线程："+local.get());;
    }
}
