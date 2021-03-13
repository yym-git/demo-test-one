package com.person.cn.demotestone.designmodel.decorator.three.act;

/**
 * @author ym.y
 * @description 煎饼加鸡蛋和香肠
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:13 2020/12/24
 */
public class BatterCakeWithEggAndSau extends BatterCakeWithEgg {
    @Override
    public String getMsg() {
        return super.getMsg() + "，再加一根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
