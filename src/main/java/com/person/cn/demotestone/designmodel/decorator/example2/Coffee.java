package com.person.cn.demotestone.designmodel.decorator.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:26 2021/3/15
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
