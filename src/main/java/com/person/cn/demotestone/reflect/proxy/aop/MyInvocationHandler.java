package com.person.cn.demotestone.reflect.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect.proxy.aop
 * @updateUser
 * @date 17:302020/12/2
 */
public class MyInvocationHandler implements InvocationHandler {
    //需要被代理的对象
    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }
//    public void setTarget(Object target) {
//        this.target = target;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil dogUtil = new DogUtil();
        dogUtil.method1();
        Object result = method.invoke(target, args);
        dogUtil.method2();
        return result;
    }
}
