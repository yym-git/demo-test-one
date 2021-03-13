package com.person.cn.demotestone.designmodel.strategy;

/**
 * @author ym.y
 * @description 电影票类：环境类
 * @package com.person.cn.demotestone.designmodel.strategy
 * @updateUser
 * @date 18:20 2020/12/16
 */
public class MoveTicket {
    private double price;
    //维持一个抽象折扣策略类的引用
    private Discount discount;

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @description 注入一个折扣类
     * @author ym.y
     * @updateUser
     * @date 18:23 2020/12/16
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     * @description 获取价格
     * @author ym.y
     * @updateUser
     * @date 18:23 2020/12/16
     */
    public double getPrice() {
        return discount.calculate(this.price);
    }
}
