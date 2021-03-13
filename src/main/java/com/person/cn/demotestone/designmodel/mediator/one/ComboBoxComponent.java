package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 组合组件类：具体组件类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:29 2020/12/17
 */
public class ComboBoxComponent extends Component {
    @Override
    public void update() {
        System.out.println("组合框增加一项：张无忌。");
    }

    public void select(){
        System.out.println("组合框选中项:小龙女。");
    }
}
