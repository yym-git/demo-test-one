package com.person.cn.demotestone.gc;

/**
 * @author ym.y
 * @description 堆溢出错误演示
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 14:53 2021/3/1
 */
public class HeapSpaceDemo {
    public static void main(String[] args) {
        String str  = "yym";
        while(true){
            str += str +"AAA"+new HeapSpaceDemo()+"hhhh";
        }
    }
}
