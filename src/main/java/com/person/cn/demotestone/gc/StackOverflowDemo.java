package com.person.cn.demotestone.gc;

/**
 * @author ym.y
 * @description 演示 栈溢出
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 14:47 2021/3/1
 */
public class StackOverflowDemo {
    public static void main(String[] args) {
        StackOverflowError();
    }
    public static  void  StackOverflowError(){
        StackOverflowError();
    }
}
