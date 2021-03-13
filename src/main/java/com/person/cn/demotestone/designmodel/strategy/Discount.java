package com.person.cn.demotestone.designmodel.strategy;

/**
 * @author ym.y
 * @description 折扣类：抽象策略
 * @package com.person.cn.demotestone.designmodel.strategy
 * @updateUser
 * @date 18:08 2020/12/16
 */
public abstract class Discount {
    public abstract double calculate(double price);
}
