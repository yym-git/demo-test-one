package com.person.cn.demotestone.test;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 16:25 2020/12/23
 */
public class ExecutorTest implements Runnable{
    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"  "+singleton);
    }
}
