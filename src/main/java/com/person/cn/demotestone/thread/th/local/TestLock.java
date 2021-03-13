package com.person.cn.demotestone.thread.th.local;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.th.local
 * @updateUser
 * @date 23:00 2021/3/2
 */
public class TestLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
