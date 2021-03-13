package com.person.cn.demotestone.designmodel.decorator;

/**
 * @author ym.y
 * @description 黑色边框装饰类：具体装饰类
 * @package com.person.cn.demotestone.designmodel.decorator
 * @updateUser
 * @date 17:59 2020/12/13
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    /**
     * @description 为对象动态添加额外职责
     * @author ym.y
     * @updateUser
     * @date 18:01 2020/12/13
     */
    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }
}
