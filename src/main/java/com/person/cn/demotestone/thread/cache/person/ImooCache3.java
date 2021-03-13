package com.person.cn.demotestone.thread.cache.person;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ym.y
 * @description 使用装饰着模式
 * 装饰类
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:58 2021/1/4
 */
public class ImooCache3<K, V> implements Computable<K, V> {
    private final HashMap<K, V> cache = new HashMap<>();
    private Computable<K, V> c;

    public ImooCache3(Computable<K, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(K k) throws Exception {
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
        ImooCache3<String,Integer> imooCache2 = new ImooCache3(new ExpensiveFunction());
      Thread th1=  new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Integer result  = imooCache2.compute("6666");
                   System.out.println("第一次计算的结果："+result);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });

        Thread th2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result  = imooCache2.compute("6667");
                    System.out.println("第二次计算的结果："+result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result  = imooCache2.compute("6666");
                    System.out.println("第三次计算的结果："+result);
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
