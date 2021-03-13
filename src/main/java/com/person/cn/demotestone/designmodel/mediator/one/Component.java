package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 抽象组件类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:21 2020/12/17
 */
public abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * @description 转发调用
     * @author ym.y
     * @updateUser
     * @date 17:23 2020/12/17
     */
    public void change() {
        mediator.componentChanged(this);
    }

    public abstract void update();
}
