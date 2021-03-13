package com.person.cn.demotestone.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect.proxy
 * @updateUser
 * @date 17:062020/12/2
 */
public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler =  new MyInvocationHandler();
        Personal obj  =(Personal) Proxy.newProxyInstance(Personal.class.getClassLoader(),new  Class[]{Personal.class},handler);
        obj.walk();
        obj.sayHello("嘻哈");
    }
}
