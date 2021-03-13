package com.person.cn.demotestone.gc;

import java.util.WeakHashMap;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 14:08 2021/3/1
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        Integer key  = new Integer(1);
        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(key,"weakHashMap");
        System.out.println("1\t"+weakHashMap);
        key = null;
        System.out.println("2\t"+weakHashMap);
        System.gc();
        System.out.println("3\t"+weakHashMap);
    }

}
