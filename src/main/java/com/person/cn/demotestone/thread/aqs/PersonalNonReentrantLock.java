package com.person.cn.demotestone.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ym.y
 * @description 基于AQS实现的不可重入锁
 * @package com.person.cn.demotestone.thread.aqs
 * @updateUser
 * @date 14:03 2021/1/7
 */
public class PersonalNonReentrantLock implements Lock, java.io.Serializable {
    private static class Sync extends AbstractQueuedSynchronizer {
        /**
         * @description 当前线程是否持有锁
         * @author ym.y
         * @updateUser
         * @date 14:06 2021/1/7
         */
        @Override
        protected boolean isHeldExclusively() {
            //state==1说明持有锁
            return getState() == 1;
        }

        /**
         * @description 尝试获取锁, 设置状态state==1
         * @author ym.y
         * @updateUser
         * @date 14:08 2021/1/7
         */
        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            if (compareAndSetState(0, 1)) {
                //设置锁的持有者
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * @description 尝试释放锁，设置state==0
         * @author ym.y
         * @updateUser
         * @date 14:11 2021/1/7
         */
        @Override
        protected boolean tryRelease(int arg) {
            assert  arg == 1;
            if (getState() == 0) {
                throw new IllegalArgumentException();
            }
            //将锁的持有者设置为null
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
    sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
