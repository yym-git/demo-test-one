package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 19:03 2020/12/23
 */
public class Customer implements  Person {
    @Override
    public void finLove() {
        System.out.println("高富帅");
        System.out.println("升高180cm");
        System.out.println("有6块腹肌");
    }
}
