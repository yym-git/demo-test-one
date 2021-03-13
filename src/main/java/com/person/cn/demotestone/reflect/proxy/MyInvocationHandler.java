package com.person.cn.demotestone.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 16:552020/12/2
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * @description  执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
     *  proxy -- 动态代理对象
     *  method -- 正在执行的方法
     *  args -- 调用目标方法时需要的参数
     * @author ym.y
     * @updateUser
     * @date  16:59 2020/12/2
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法:"+method);
        if(args != null){
            System.out.println("执行方法时传入的参数：");
            for(Object obj  : args ){
                System.out.println(obj);
            }
        }else{
            System.out.println("调用该方法没有实参！");
        }
        return null;
    }
}

