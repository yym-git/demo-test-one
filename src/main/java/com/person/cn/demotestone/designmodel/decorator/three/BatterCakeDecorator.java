package com.person.cn.demotestone.designmodel.decorator.three;

/**
 * @author ym.y
 * @description 抽象装饰类
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:24 2020/12/24
 */
public abstract class BatterCakeDecorator extends BatterCake {
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.batterCake.getPrice();
    }
}
