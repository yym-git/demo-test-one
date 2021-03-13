package com.person.cn.demotestone.designmodel.decorator;

/**
 * @author ym.y
 * @description 文本框：具体构件类
 * @package com.person.cn.demotestone.designmodel.decorator
 * @updateUser
 * @date 17:50 2020/12/13
 */
public class TextBoxComponent extends  Component {
    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}
