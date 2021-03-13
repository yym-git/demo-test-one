package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 文本标签组件：具体组件类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 19:04 2020/12/17
 */
public class Label extends Component {
    @Override
    public void update() {
        System.out.println("文本标签内容改变，客户信息总数增加1。");
    }
}
