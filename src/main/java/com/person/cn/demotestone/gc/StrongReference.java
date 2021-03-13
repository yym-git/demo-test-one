package com.person.cn.demotestone.gc;

/**
 * @author ym.y
 * @description 演示强引用
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 23:49 2021/2/28
 */
public class StrongReference {
    public static void main(String[] args) {
        Object obj1= new Object();
        Object obj2 = obj1;
        obj1 =null;
        System.gc();
        System.out.println(obj2);
    }
}
