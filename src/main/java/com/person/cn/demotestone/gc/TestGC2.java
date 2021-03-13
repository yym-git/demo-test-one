package com.person.cn.demotestone.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 20:44 2021/1/17
 */
public class TestGC2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList(5);
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        list.add("");
        System.out.println("大小："+list.size());
        System.out.println("设置值："+list.set(1,"1"));
    }
}
