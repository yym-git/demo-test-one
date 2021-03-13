package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.Button;

/**
 * @author ym.y
 * @description Spring按钮类：具体产品
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:05 2020/12/11
 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("Spring-显示浅绿色按钮");
    }
}
