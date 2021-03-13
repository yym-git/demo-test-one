package com.person.cn.demotestone.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 22:53 2021/1/18
 */
public class Student {
    ReentrantLock lock = new ReentrantLock(true);
    private String name;
    private String age;
}
