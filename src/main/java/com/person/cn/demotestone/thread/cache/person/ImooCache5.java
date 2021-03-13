package com.person.cn.demotestone.thread.cache.person;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ym.y
 * @description 缩小了synchronize的粒度，提高性能，但依然是线程不安全的
 * 装饰类
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:58 2021/1/4
 */
public class ImooCache5<K, V> implements Computable<K, V> {
    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    private Computable<K, V> c;

    public ImooCache5(Computable<K, V> c) {
        this.c = c;
    }

    @Override
    public V compute(K k) throws Exception {
        System.out.println("进入缓存机制");
        V result = cache.get(k);
        if (result == null) {
            //为了提
            result = c.compute(k);
            //放入缓存中
            cache.put(k, result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImooCache5<String, Integer> imooCache2 = new ImooCache5(new ExpensiveFunction());
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = imooCache2.compute("6666");
                    System.out.println("第一次计算的结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = imooCache2.compute("6667");
                    System.out.println("第二次计算的结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = imooCache2.compute("6666");
                    System.out.println("第三次计算的结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        th1.start();
        th2.start();
        th3.start();
    }
}
