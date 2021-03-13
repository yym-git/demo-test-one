package com.person.cn.demotestone.thread.threadcoreknowledge;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 15:15 2020/12/25
 */
public class BestThreadStop implements  Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new  Thread(new BestThreadStop());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("main:"+thread.isInterrupted());
    }

    @Override
    public void run() {
        // -------------------------线程不会停止------------------------------
//        while(!Thread.currentThread().isInterrupted()){
////            method();
//            try {
//                method2();
//            } catch (InterruptedException e) {
//                System.out.println("异常处理！");
//                e.printStackTrace();
//                Thread.currentThread().setDaemon(true);
//            }
//        }


        while(true){
            if(Thread.currentThread().isInterrupted()){
                break;
            }
            try {
                method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("异常捕获:"+Thread.currentThread().isInterrupted());
            }
        }

//        --------------------一下线程终止-------------------------
//        try {
//            while(!Thread.currentThread().isInterrupted()){
//                System.out.println("go");
//                method2();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * @description   方法内部捕获异常，线程将无法停止
     * @author ym.y
     * @updateUser
     * @date  15:20 2020/12/25
     */
    public  void method(){
        System.out.println("hhhh");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void method2() throws InterruptedException {
        System.out.println("嘻嘻");
        System.out.println("方法内"+Thread.currentThread().isInterrupted());
        Thread.sleep(5000);
    }
}
