package com.person.cn.demotestone.data.construct.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.data.construct.lru
 * @updateUser
 * @date 15:32 2021/3/4
 */
public class LRULinkedHashMap extends LinkedHashMap {
    private int capacity;
    public LRULinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity =capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap lruDemo = new LRULinkedHashMap(3);
        lruDemo.put(1,"a");
        lruDemo.put(2,"b");
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(4,"d");
        System.out.println(lruDemo.keySet());

    }
}
