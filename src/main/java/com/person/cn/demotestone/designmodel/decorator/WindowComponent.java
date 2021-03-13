package com.person.cn.demotestone.designmodel.decorator;

/**
 * @author ym.y
 * @description 窗口类：具体的构件类
 * @package com.person.cn.demotestone.designmodel.decorator
 * @updateUser
 * @date 17:49 2020/12/13
 */
public class WindowComponent extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }
}
