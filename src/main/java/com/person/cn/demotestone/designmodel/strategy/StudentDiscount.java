package com.person.cn.demotestone.designmodel.strategy;

/**
 * @author ym.y
 * @description 学生票折扣类：具体策略类
 * @package com.person.cn.demotestone.designmodel.strategy
 * @updateUser
 * @date 18:10 2020/12/16
 */
public class StudentDiscount extends Discount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票，原价为："+price);
        return price * 0.8;
    }
}
