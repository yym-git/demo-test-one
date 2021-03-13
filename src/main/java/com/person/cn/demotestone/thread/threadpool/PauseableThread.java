package com.person.cn.demotestone.thread.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description 可暂停和恢复的线程池
 * @package com.person.cn.demotestone.thread.threadpool
 * @updateUser
 * @date 16:35 2020/12/29
 */
public class PauseableThread extends ThreadPoolExecutor {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean flag = false;
    Condition condition = lock.newCondition();

    public PauseableThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public PauseableThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public PauseableThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public PauseableThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

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

    private void pause() {
        lock.lock();
        try {
            flag = true;
        } finally {
            lock.unlock();
        }
    }

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
        PauseableThread pool = new PauseableThread(5, 10, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        Runnable runnable = new  Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程被执行了！");
            }
        };
        for(int  i  =0; i< 100000; i++){
            pool.submit(runnable);
        }
        //1.5秒后停止线程池
        Thread.sleep(1500);
        pool.pause();
        System.out.println("线程池已经暂停了");
        pool.execute(runnable);
        Thread.sleep(2000);
        pool.resume();
        System.out.println("线程池已经启动了");

    }
}
