package com.person.cn.demotestone.thread.condition;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 14:13 2021/1/12
 */
public class MyRun {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA myThreadA =   new  MyThreadA(myService);
        MyThreadB myThreadB =   new  MyThreadB(myService);
        new  Thread(myThreadA,"线程A").start();
        new  Thread(myThreadB,"线程B").start();
    }
}
