package com.person.cn.demotestone.thread.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 17:09 2020/12/29
 */
public class TestThreadPool extends ThreadPoolExecutor {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean flag;
    Condition condition = lock.newCondition();

    public TestThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TestThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TestThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TestThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    /**
     * @description 线程执行前会调用该方法校验线程池的状态
     * @author ym.y
     * @updateUser
     * @date 17:12 2020/12/29
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        lock.lock();
        try {
            while (flag) {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * @description 暂停线程池
     * @author ym.y
     * @updateUser
     * @date 17:10 2020/12/29
     */
    private void pause() {
        lock.lock();
        try {
            flag = true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description 启动线程池
     * @author ym.y
     * @updateUser
     * @date 17:15 2020/12/29
     */
    private void resume() {
        lock.lock();
        try {
            flag = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadPool testPool = new TestThreadPool(5, 10, 10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程被执行！");
            }
        };

        //需要执行的任务100000个
        for (int i = 0; i < 100000; i++) {
            testPool.execute(runnable);
        }
        Thread.sleep(1000);
        //暂停线程池
        testPool.pause();
        System.out.println("线程池暂停了");
        testPool.execute(runnable);
        Thread.sleep(1500);
        testPool.resume();
        System.out.println("线程池启动了");
    }
}
