package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.TextField;

/**
 * @author ym.y
 * @description Spring文本框类：具体产品
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:08 2020/12/11
 */
public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("Spring-显示绿色边框文本框");
    }
}
