package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 抽象中介者
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:19 2020/12/17
 */
public abstract class Mediator {
    //组件改变方法
    public abstract void componentChanged(Component component);
}
