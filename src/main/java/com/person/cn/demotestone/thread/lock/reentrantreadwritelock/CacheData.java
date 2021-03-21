package com.person.cn.demotestone.thread.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ym.y
 * @description 实际缓存失效，重新刷新缓存---锁降级
 * ReentrantReadWriteLock：使用锁降级防止缓存穿透
 * @package com.person.cn.demotestone.thread.lock.reentrantreadwritelock
 * @updateUser
 * @date 10:24 2020/12/31
 */
public class CacheData {
    //缓存数据
    Object cacheDate;
    //缓存是否有效标识
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void processCacheData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            //缓存失效，需要写入缓存，需要获取写锁，因为不支持升级，所以在获取写锁前先释放读锁
            rwl.readLock().unlock();
            //获取写锁
            rwl.writeLock().lock();
            try {
                //需要再次判断缓存的有效性，因为在释放读锁和获取写锁的间隙，可能有其他线程修改了数据
                if (!cacheValid) {
                    cacheDate = new Object();
                    cacheValid = true;
                }
                //在不释放写锁的情况下获取了读锁--锁降级
                rwl.readLock().lock();
            } finally {
                //释放写锁，但是依然保持读锁
                rwl.writeLock().unlock();
            }
        }

        try {
            System.out.println("打印缓存数据：" + cacheDate);
        } finally {
            //最后释放读锁
            rwl.readLock().unlock();
        }
    }

}
