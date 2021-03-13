package com.person.cn.demotestone.thread.com;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 13:462020/11/16
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(; ;){
                }
            }
        });
        // 只有当所有的非守护线程结束后，JVM虚拟机才会退出
        threadOne.setDaemon(true);
        threadOne.start();
        System.out.println("main thread is over!");
    }
}
