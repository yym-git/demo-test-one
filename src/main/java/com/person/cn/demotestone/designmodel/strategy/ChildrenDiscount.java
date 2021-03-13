package com.person.cn.demotestone.designmodel.strategy;

import java.math.BigDecimal;

/**
 * @author ym.y
 * @description 儿童票：具体策略
 * @package com.person.cn.demotestone.designmodel.strategy
 * @updateUser
 * @date 18:12 2020/12/16
 */
public class ChildrenDiscount extends Discount {
    @Override
    public double calculate(double price) {
        System.out.println("儿童票,原价为："+price);
        BigDecimal bg = new BigDecimal(String.valueOf(price));
        if (bg.compareTo(new BigDecimal("20")) > 0) {
            return price - 10;
        } else {
            return price;
        }
    }
}
