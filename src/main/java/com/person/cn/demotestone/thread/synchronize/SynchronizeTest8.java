package com.person.cn.demotestone.thread.synchronize;

/**
 * @author ym.y
 * @description 可重入粒度：调用类本方法
 * @package com.person.cn.demotestone.thread.synchronize
 * @updateUser
 * @date 11:13 2020/12/25
 */
public class SynchronizeTest8 {
    int i = 0;
    public synchronized void method() {
        System.out.println("i="+i);
        if (i == 0) {
            i++;
            method();
        }
    }

    public static void main(String[] args) {
        new  SynchronizeTest8().method();
    }
}
