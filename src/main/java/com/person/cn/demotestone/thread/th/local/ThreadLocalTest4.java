package com.person.cn.demotestone.thread.th.local;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.th.local
 * @updateUser
 * @date 11:22 2020/12/30
 */
public class ThreadLocalTest4 {
    private static ThreadLocal<String> localValue = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + ":" + localValue.get());
        localValue.remove(); //清除本地线程中的变量
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localValue.set("threadOne local Value");
                print("线程一");
                System.out.println("线程一内部："+localValue.get());
            }
        });

        Thread threadTwo =new Thread(new Runnable() {
            @Override
            public void run() {
                localValue.set("threadTwo local value");
                print("线程二");
                System.out.println("线程二内部："+localValue.get());

            }
        });
        //启动线程
        threadOne.start();
        threadTwo.start();
        System.out.println("主线程获取的值："+localValue.get());
    }
}
