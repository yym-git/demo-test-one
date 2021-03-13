package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.ComboBox;

/**
 * @author ym.y
 * @description Summer组合框类：具体产品
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:15 2020/12/11
 */
public class SummerComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("Summer-显示蓝色边框组合框");
    }
}
