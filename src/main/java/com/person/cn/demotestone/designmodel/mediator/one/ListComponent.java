package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 列表框：具体组件类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:26 2020/12/17
 */
public class ListComponent  extends Component{
    @Override
    public void update() {
        System.out.println("列表框增加一项：张无忌。");
    }

    public void select(){
        System.out.println("列表框选中项：小龙女。");
    }
}
