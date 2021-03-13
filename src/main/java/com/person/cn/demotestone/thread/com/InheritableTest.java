package com.person.cn.demotestone.thread.com;

/**
 * @author ym.y
 * @description Inheritable具有继承性
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 15:082020/11/16
 */
public class InheritableTest {
    public static void main(String[] args) {
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("父线程的内容");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程获父线程的变量:"+inheritableThreadLocal.get());
            }
        });
        thread.start();
        System.out.println("父线程获取:"+inheritableThreadLocal.get());
    }
}
