package com.person.cn.demotestone.gc;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ym.y
 * @description 元空间溢出
 * JVM参数 -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * <p>
 * Metaspace是方法区在Hotspot中的实现，它与持久代最大的区别就是Metaspace并不存在虚拟机内存中，而是使用本地内存
 * <p>
 * 永久代存放的信息：
 * 虚拟机的加载信息
 * 常量池
 * 静态变量
 * 即使编译后的代码
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 16:51 2021/3/1
 */
public class MetaSpaceOOMDemo {
    static class OOMTest {
    }

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setUseCache(false);
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("*************多少次以后发生了异常" +i);
            e.printStackTrace();
        }
    }
}
