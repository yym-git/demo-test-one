package com.person.cn.demotestone.reflect.proxy.aop;

import java.lang.reflect.Proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect.proxy.aop
 * @updateUser
 * @date 17:352020/12/2
 */
public class MyProxyFactory {
    //为指定的target生成动态代理对象
    public static  Object getProxy(Object target) throws Exception{
        MyInvocationHandler handler = new MyInvocationHandler(target);
        //为MyInvocationHandler设置target对象
//        handler.setTarget(target);
        //创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
    }
}
