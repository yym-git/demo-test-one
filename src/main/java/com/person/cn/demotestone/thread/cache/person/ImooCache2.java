package com.person.cn.demotestone.thread.cache.person;

import java.util.HashMap;

/**
 * @author ym.y
 * @description 使用装饰着模式
 * 装饰类
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:58 2021/1/4
 */
public class ImooCache2<K, V> implements Computable<K, V> {
    private final HashMap<K, V> cache = new HashMap<>();
    private Computable<K, V> c;

    public ImooCache2(Computable<K, V> c) {
        this.c = c;
    }

    @Override
    public  V compute(K k) throws Exception {
        System.out.println("进入缓存机制");
        V result = cache.get(k);
        if (result == null) {
            result = c.compute(k);
            //放入缓存中
            cache.put(k,result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImooCache2<String,Integer> imooCache2 = new ImooCache2(new ExpensiveFunction());
        Integer result = imooCache2.compute("666");
        System.out.println("第一次计算结果："+result);
        Integer result2 = imooCache2.compute("666");
        System.out.println("第二次计算结果："+result2);
    }
}
