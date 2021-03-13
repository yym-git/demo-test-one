package com.person.cn.demotestone.thread.threadcoreknowledge;

/**
 * @author ym.y
 * @description 继承Thread和实现Runnable同时使用：会执行继承而来的run方法
 * @package com.person.cn.demotestone.thread.threadcoreknowledge
 * @updateUser
 * @date 12:50 2020/12/25
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new  Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("来自Runnable实现");
            }
        }){
            @Override
            public void run() {
                System.out.println("来自Thread继承");
            }
        }.start();
    }
}
