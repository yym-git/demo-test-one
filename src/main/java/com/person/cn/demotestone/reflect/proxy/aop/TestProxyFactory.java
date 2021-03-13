package com.person.cn.demotestone.reflect.proxy.aop;

import java.lang.reflect.Proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect.proxy.aop
 * @updateUser
 * @date 17:412020/12/2
 */
public class TestProxyFactory {
    public static void main(String[] args) throws Exception {
        Dog target = new GunDog();
//        Dog dog = (Dog) MyProxyFactory.getProxy(target);
//        dog.info();
//        dog.run();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        Dog dog = (Dog)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
        dog.info();
    }
}
