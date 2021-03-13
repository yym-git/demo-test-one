package com.person.cn.demotestone.thread.synchronize;

/**
 * @author ym.y
 * @description 可重入粒度：调用父类的方法
 * @package com.person.cn.demotestone.thread.synchronize
 * @updateUser
 * @date 11:13 2020/12/25
 */
public class SynchronizeTest10 {
    public synchronized void doSomething() {
        System.out.println("父类方法");
    }

    public static void main(String[] args) {
        Children children = new Children();
        children.doSomething();
    }
}

class Children extends SynchronizeTest10 {
    @Override
    public synchronized void doSomething() {
        System.out.println("子类方法");
        super.doSomething();
    }
}
