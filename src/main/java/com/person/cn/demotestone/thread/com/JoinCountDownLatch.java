package com.person.cn.demotestone.thread.com;

import java.util.concurrent.CountDownLatch;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 11:482020/11/25
 */
public class JoinCountDownLatch {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne  = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
                System.out.println("线程1执行完毕.........");
            }
        });

      Thread threadTwo = new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } finally {
                  countDownLatch.countDown();
              }
              System.out.println("线程2执行完毕.......");
          }
      });

        threadOne.start();
        threadTwo.start();
        System.out.println("等待所有子线程执行完毕........");
        countDownLatch.await();
        System.out.println("所有子线程执行完毕.....");
    }
}
