package com.person.cn.demotestone.designmodel.singleton.zhuce;

import org.apache.catalina.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.singleton.zhuce
 * @updateUser
 * @date 18:09 2020/12/23
 */
public class ThreadLocalSingleton {
    private ThreadLocalSingleton() {
    }
    private final static ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
    }
}
