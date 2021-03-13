package com.person.cn.demotestone.thread.com;

/**
 * @author ym.y
 * @description  ThreadLocal不具有继承性
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 14:382020/11/16
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();


    public static void main(String[] args) {
        localVariable.set("main thread local variable");
        Thread threadOne  = new Thread(new Runnable() {
            @Override
            public void run() {
//                localVariable.set("threadOne  local variable");
                System.out.println("threadOne  remove after: "+localVariable.get());
            }
         });
        threadOne.start();
        System.out.println("main thread: " +localVariable.get());

    }
}
