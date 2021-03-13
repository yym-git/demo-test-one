package com.person.cn.demotestone.designmodel.decorator.three;

/**
 * @author ym.y
 * @description 基础套餐
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:23 2020/12/24
 */
public class BaseBatterCake extends BatterCake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
