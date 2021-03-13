package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 19:13 2020/12/23
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        Person person = (Person) new JDKMeipo().getInstance(new Customer());
        person.finLove();
    }
}
