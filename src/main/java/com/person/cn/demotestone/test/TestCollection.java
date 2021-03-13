package com.person.cn.demotestone.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 16:14 2021/2/25
 */
public class TestCollection {
    public static void main(String[] args) {
//        test2();
        test3();
    }

    /**
     * @description 线程不安全
     * @author ym.y
     * @updateUser
     * @date 16:34 2021/2/25
     */
    public static void test1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i + 1)).start();
        }
    }

    /**
     * @description 线程全
     * @author ym.y
     * @updateUser
     * @date 16:34 2021/2/25
     */
    public static void test2() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i + 1)).start();
        }
    }


    /**
     * @description  线程安全
     * @author ym.y
     * @updateUser
     * @date  17:06 2021/2/25
     */
    public  static void  test3(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i + 1)).start();
        }
    }

    /**
     * @description  线程安全set
     * @author ym.y
     * @updateUser
     * @date  17:08 2021/2/25
     */
    public static void testSet(){
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set=new CopyOnWriteArraySet<>();
         new HashSet<String>().add("");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i + 1)).start();
        }
    }
}
