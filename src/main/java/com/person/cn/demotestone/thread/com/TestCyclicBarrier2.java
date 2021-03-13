package com.person.cn.demotestone.thread.com;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description
 *  所有子线程的一阶段执行完成后才会执行所有线程的二阶段，接着执行所有线程的三阶段
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 15:302020/11/25
 */
public class TestCyclicBarrier2 {
    private  static CyclicBarrier cyclicBarrier =new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" 汇总");
        }
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("线程一的step1");
                    cyclicBarrier.await();
                    System.out.println("线程一的step2");
                    cyclicBarrier.await();
                    System.out.println("线程一的step3");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("线程二的step1");
                    cyclicBarrier.await();
                    System.out.println("线程二的step2");
                    cyclicBarrier.await();
                    System.out.println("线程二的step3");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("线程三的step1");
                    cyclicBarrier.await();
                    System.out.println("线程三的step2");
                    cyclicBarrier.await();
                    System.out.println("线程三的step3");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        //关闭线程池
        executorService.shutdown();
    }
}
