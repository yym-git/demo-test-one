package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 19:04 2020/12/23
 */
public class JDKMeipo implements InvocationHandler {
    //被代理的目标对象
    private Object target;

    public  Object getInstance(Object obj) {
        target = obj;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("媒婆自我介绍。。。。。");
        System.out.println("开始物色对象。。。。。。");
    }


    private void after() {
        System.out.println("合适就开始处理。。。。。。");
    }
}
