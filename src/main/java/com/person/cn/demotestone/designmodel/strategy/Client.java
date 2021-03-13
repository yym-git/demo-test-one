package com.person.cn.demotestone.designmodel.strategy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.strategy
 * @updateUser
 * @date 18:24 2020/12/16
 */
public class Client {
    public static void main(String[] args) {
        MoveTicket moveTicket = new MoveTicket();
        moveTicket.setPrice(30);
        Discount discount;
//        discount = new ChildrenDiscount();
//        discount = new StudentDiscount();
        discount = new VIPDiscount();
        moveTicket.setDiscount(discount);
        double discountPrice = moveTicket.getPrice();
        System.out.println("折扣价为："+discountPrice);
    }


}
