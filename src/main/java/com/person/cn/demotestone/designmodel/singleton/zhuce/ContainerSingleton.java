package com.person.cn.demotestone.designmodel.singleton.zhuce;

import java.io.ObjectInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ym.y
 * @description 容器式单例：非线程安全的
 * @package com.person.cn.demotestone.designmodel.singleton.zhuce
 * @updateUser
 * @date 17:59 2020/12/23
 */
public class ContainerSingleton {
    private ContainerSingleton() {
    }
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
                ioc.put(className, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        } else {
            return ioc.get(className);
        }
    }
}
