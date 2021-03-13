package com.person.cn.demotestone.designmodel.strategy;

/**
 * @author ym.y
 * @description VIP会员票折扣类：具体策略类
 * @package com.person.cn.demotestone.designmodel.strategy
 * @updateUser
 * @date 18:19 2020/12/16
 */
public class VIPDiscount extends Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票，原价位："+price);
        System.out.println("增加积分");
        return price * 0.5;
    }
}
