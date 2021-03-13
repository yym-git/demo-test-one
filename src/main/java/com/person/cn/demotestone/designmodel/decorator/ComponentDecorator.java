package com.person.cn.demotestone.designmodel.decorator;

/**
 * @author ym.y
 * @description 构建装饰类：抽象装饰类
 * @package com.person.cn.demotestone.designmodel.decorator
 * @updateUser
 * @date 17:52 2020/12/13
 */
public class ComponentDecorator extends Component {
    private  Component component;
    //注入抽象构件类对象
    public  ComponentDecorator(Component component){
        this.component = component;
    }
    @Override
    public void display() {
        component.display();
    }
}
