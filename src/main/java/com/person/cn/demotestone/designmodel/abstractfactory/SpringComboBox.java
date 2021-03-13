package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.ComboBox;

/**
 * @author ym.y
 * @description Spring组合框类：具体产品
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:13 2020/12/11
 */
public class SpringComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("Spring-显示绿色边框组合框");
    }
}
