package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 文本框类：具体组件类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:31 2020/12/17
 */
public class TextBoxComponent extends Component{
    @Override
    public void update() {
        System.out.println("客户信息增加成功后，文本框清空！");
    }

    public void setText(){
        System.out.println("文本框显示：小龙女！");
    }
}
