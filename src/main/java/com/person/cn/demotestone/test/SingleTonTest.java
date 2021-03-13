package com.person.cn.demotestone.test;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 16:27 2020/12/23
 */
public class SingleTonTest {
    public static void main(String[] args) {
        new  Thread(new ExecutorTest()).start();
        new  Thread(new ExecutorTest()).start();
        System.out.println("end");
    }
}
