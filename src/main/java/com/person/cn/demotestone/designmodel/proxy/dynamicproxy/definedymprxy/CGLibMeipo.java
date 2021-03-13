package com.person.cn.demotestone.designmodel.proxy.dynamicproxy.definedymprxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ym.y
 * @description CGLib代理
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy.definedymprxy
 * @updateUser
 * @date 11:40 2020/12/24
 */
public class CGLibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        //要把哪个类设置为即将生成的新类的父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }

    private void before() {
        System.out.println("增强方法before");
    }

    private void after() {
        System.out.println("增强方法after");
    }
}
