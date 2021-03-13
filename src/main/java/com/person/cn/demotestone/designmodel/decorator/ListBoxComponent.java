package com.person.cn.demotestone.designmodel.decorator;

/**
 * @author ym.y
 * @description 列表框类：具体构件类
 * @package com.person.cn.demotestone.designmodel.decorator
 * @updateUser
 * @date 17:51 2020/12/13
 */
public class ListBoxComponent extends  Component {
    @Override
    public void display() {
        System.out.println("显示列表框！");
    }
}
