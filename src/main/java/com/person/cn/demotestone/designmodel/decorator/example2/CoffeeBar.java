package com.person.cn.demotestone.designmodel.decorator.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:41 2021/3/15
 */
public class CoffeeBar {
    public static void main(String[] args) {
        Drink longBlank = new LongBlank();
        System.out.println("费用："+longBlank.cost());
        System.out.println("描述："+longBlank.getDes());

        //加入牛奶
        longBlank = new Mike(longBlank);
        System.out.println("加入牛奶后的费用："+longBlank.cost());
        System.out.println("加入牛奶后的描述："+longBlank.getDes());

        //加入巧克力
        longBlank = new Chocolate(longBlank);
        System.out.println("加入牛奶、巧克力后的费用："+longBlank.cost());
        System.out.println("加入牛奶、巧克力后的描述："+longBlank.getDes());
    }
}
