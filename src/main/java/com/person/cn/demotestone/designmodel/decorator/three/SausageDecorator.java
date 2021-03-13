package com.person.cn.demotestone.designmodel.decorator.three;

/**
 * @author ym.y
 * @description 香肠装饰类
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:32 2020/12/24
 */
public class SausageDecorator extends BatterCakeDecorator {
    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "，再加一根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
