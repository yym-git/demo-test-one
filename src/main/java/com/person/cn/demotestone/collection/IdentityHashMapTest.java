package com.person.cn.demotestone.collection;

import java.util.IdentityHashMap;

/**
 * @author ym.y
 * @description IdentityHashMap只有当两个可以严格相等时，key1=key2时，才认为两个key相等
 * @package com.person.cn.demotestone.collection
 * @updateUser
 * @date 13:58 2020/12/10
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> ihm = new IdentityHashMap<>();
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 79);
        ihm.put("java", 79);
        ihm.put("java", 77);
        System.out.println(ihm);
        String str = "疯狂Java";
        String str1 = "疯狂";
        String str2 = "Java";
        String str3 = str1 + str2;
        System.out.println(str==str3);
    }
}
