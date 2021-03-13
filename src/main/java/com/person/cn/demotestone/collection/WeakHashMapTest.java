package com.person.cn.demotestone.collection;

import java.util.WeakHashMap;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.collection
 * @updateUser
 * @date 13:51 2020/12/10
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<String,String> whm = new WeakHashMap();
        whm.put(new String("语文"),new  String("良好"));
        whm.put(new String("数学"),new  String("及格"));
        whm.put(new String("英语"),new  String("中等"));
        whm.put("java",new String("中等"));
        System.out.println(whm);
        System.gc();
        System.runFinalization();
        System.out.println("强制垃圾回收后");
        System.out.println(whm);

    }
}
