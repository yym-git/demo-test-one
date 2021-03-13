package com.person.cn.demotestone.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.lock
 * @updateUser
 * @date 16:152020/11/20
 */
public class Point {
    private double x, y;
    //锁实例
    private final StampedLock stampedLock = new StampedLock();

    /**
     * 悲观写锁
     * @param deltaX
     * @param deltaY
     */
    void move(double deltaX, double deltaY) {
        //获取写锁后，其他线程要不能获取读锁
        long stamp = stampedLock.writeLock();
        try {
            x = x + deltaX;
            y = y + deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    /**
     * 乐观读锁
     *
     * @return
     */
    double distanceFromOrigin() {
        // 1尝试获取乐观读锁
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        //判断在1获取读锁标记后，有没有其他线程获取写锁
        if (!stampedLock.validate(stamp)) {
            //被抢占则获取一个共享读锁
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                //释放共享读锁
                stampedLock.unlockRead(stamp);
            }
        }
        //没有则返回计算结果
        return Math.sqrt(currentX*currentX+currentY*currentY);
    }

    // 使用悲观锁获取读锁，并尝试转换为写锁
    void moveIfAtOrigin(double newX, double newY){
        // 1. 悲观读锁
       long stamp =  stampedLock.readLock();
       try {
           //2. 如果当前点在原点则移动
           while(x == 0.0  && y == 0.0 ){
               //  3. 尝试将 1 获取的读锁升级为写锁
              long ws  =  stampedLock.tryConvertToWriteLock(stamp);
              // 因为在线程没有获取写锁的情况下会返回一个非0的stamp标识
               //4. 升级成功，则更新戳记，并重新设置坐标值，然后退出循环
              if(ws!= 0 ){
                  stamp =  ws;
                  x = newX;
                  y  = newY;
                  break;
              }else{
                  //读锁升级写锁失败后则释放读锁，显示获取独占写锁，然后循环重试
                  stampedLock.unlockRead(stamp);
                  stamp = stampedLock.writeLock();
              }
           }
       }finally {
           stampedLock.unlock(stamp);
       }
    }
}
