package com.person.cn.demotestone.thread.cache.person;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description 最简单的形式：HashMap
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:32 2021/1/4
 */
public class ImooCache1 {
    private final ConcurrentHashMap<String, Integer> cache = new ConcurrentHashMap<>();

    public Integer computer(String userId) throws InterruptedException {
        Integer result = cache.get(userId);
        if (result == null) {
            result = doCompute(userId);
            cache.put(userId, result);
        }
        return result;
    }

    private Integer doCompute(String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return new Integer(userId);
    }

    public static void main(String[] args) throws InterruptedException {
        ImooCache1 cache1 = new ImooCache1();
        System.out.println("开始计算了");
        Integer result = cache1.computer("13");
        System.out.println("第一次计算的结果：" + result);
        Integer result2 = cache1.computer("13");
        System.out.println("第二次计算的结果：" + result2);
    }
}
