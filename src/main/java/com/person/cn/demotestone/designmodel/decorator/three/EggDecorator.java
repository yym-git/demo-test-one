package com.person.cn.demotestone.designmodel.decorator.three;

/**
 * @author ym.y
 * @description 鸡蛋装饰类
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:28 2020/12/24
 */
public class EggDecorator extends BatterCakeDecorator {
    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "加一个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
