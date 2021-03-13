package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.Button;

/**
 * @author ym.y
 * @description Summer按钮类：具体的产品类
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:06 2020/12/11
 */
public class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("Summer-显示浅蓝色按钮");
    }
}
