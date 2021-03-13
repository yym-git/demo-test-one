package com.person.cn.demotestone.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock
 * @updateUser
 * @date 15:342020/11/20
 */
public class TestStampedLock {
    static ExecutorService executorService = Executors.newFixedThreadPool(10);
    static StampedLock lock = new StampedLock();
    static long mill = 5000;
    static int count = 0;

    private static long writeLock() {
        // 获取独占式写锁
        long stamp = lock.writeLock();
        count = count + 1;
        //释放写锁
        lock.unlockWrite(stamp);
        System.out.println("数据写入完成");
        return System.currentTimeMillis();
    }

    private static void readLock() {
        executorService.submit(() -> {
            int currentCount = 0;
            long stamp = lock.readLock();
            try {
                currentCount = count;
                try {
                    TimeUnit.MILLISECONDS.sleep(mill);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlockRead(stamp);
            }
            System.out.println("readLock==" + currentCount);
        });

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取乐观读锁
     */
    private static void optimisticLock() {
      executorService.submit(()->{
          long stamp = lock.tryOptimisticRead();
          int currentCount = count;
          try {
              // 休眠5秒
              TimeUnit.MILLISECONDS.sleep(mill);
          } catch (Exception e) {
              e.printStackTrace();
          }

          //校验是否有其他线程获取到了写锁
          if (!lock.validate(stamp)) {
              // 其他线程获取到了写锁
              //获取悲观读锁
              System.out.println("其他线程获取了写锁");
              try {
                  stamp = lock.readLock();
                  // 重新获取变量值
                  currentCount = count;
              } finally {
                  lock.unlockRead(stamp);
              }
          }
          // 如果count没有被其他线程修改，直接打印
          System.out.println("currentCount== "+currentCount);
      });
        executorService.shutdown();
    }

    public static void main(String[] args) {
        long b1 = System.currentTimeMillis();
//        readLock();
        optimisticLock();
        long b2 = writeLock();
        System.out.println(b2 - b1);
    }
}
