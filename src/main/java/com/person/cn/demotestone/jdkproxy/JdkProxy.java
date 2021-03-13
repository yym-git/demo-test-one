package com.person.cn.demotestone.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.jdkproxy
 * @updateUser
 * @date 12:54 2021/1/27
 */
public class JdkProxy implements InvocationHandler {
    private  UserDao userDao;
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        Class<?> clazz = userDao.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permissions();
        Object obj  = method.invoke(userDao,args);
        myAspect.log();
        return obj;
    }
}
