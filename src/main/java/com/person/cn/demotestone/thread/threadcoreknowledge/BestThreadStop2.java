package com.person.cn.demotestone.thread.threadcoreknowledge;

/**
 * @author ym.y
 * @description 在方法中捕获到中断异常后，重新设置中断标志
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 15:15 2020/12/25
 */
public class BestThreadStop2 implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new BestThreadStop2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序中断，程序运行结束！");
                break;
            }
            try {
                method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @description 方法内部捕获异常，同时重新设置线程状态为中断
     * @author ym.y
     * @updateUser
     * @date 15:20 2020/12/25
     */
    public void method() {
        System.out.println("hhhh");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //重新设置中断
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public void method2() throws InterruptedException {
        System.out.println("hhhh");
        Thread.sleep(2000);

    }
}
