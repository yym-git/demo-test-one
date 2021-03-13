package com.person.cn.demotestone.designmodel.proxy.dynamicproxy.definedymprxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy.definedymprxy
 * @updateUser
 * @date 11:48 2020/12/24
 */
public class CGLibTest {
    public static void main(String[] args) {
        Customer customer = (Customer)new  CGLibMeipo().getInstance(Customer.class);
        customer.findLove();
    }
}
