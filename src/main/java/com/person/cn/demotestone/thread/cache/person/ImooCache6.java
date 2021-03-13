package com.person.cn.demotestone.thread.cache.person;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author ym.y
 * @description 利用Future避免重复计算
 * 装饰类
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:58 2021/1/4
 */
public class ImooCache6<K, V> implements Computable<K, V> {
    private final ConcurrentHashMap<K, Future<V>> cache = new ConcurrentHashMap<>();
    private Computable<K, V> c;

    public ImooCache6(Computable<K, V> c) {
        this.c = c;
    }

    @Override
    public V compute(K args) throws Exception {
        Future<V> f = cache.get(args);
        if (f == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(args);
                }
            };
            FutureTask<V> ft = new FutureTask<>(callable);
//            cache.put(args,ft);
            //key对应的value不存在则，返回null，如果存在则不会覆盖
            f = cache.putIfAbsent(args, ft);
            if(f == null ){
                f = ft;
                System.out.println("从FutureTask调用了计算函数");
                ft.run();
            }
        }
        return f.get();
    }

    public static void main(String[] args) throws Exception {
        ImooCache6<String, Integer> imooCache2 = new ImooCache6(new ExpensiveFunction());
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
