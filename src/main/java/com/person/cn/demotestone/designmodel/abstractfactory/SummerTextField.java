package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.TextField;

/**
 * @author ym.y
 * @description Summer文本框类：具体的产品
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:11 2020/12/11
 */
public class SummerTextField  implements TextField {
    @Override
    public void display() {
        System.out.println("Summer-显示蓝色边框文本框");
    }
}
