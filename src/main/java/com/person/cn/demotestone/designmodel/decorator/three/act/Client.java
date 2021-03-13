package com.person.cn.demotestone.designmodel.decorator.three.act;

/**
 * @author ym.y
 * @description 模拟现实场景：非装饰模式
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:15 2020/12/24
 */
public class Client {
    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getMsg()+"，价格:"+batterCake.getPrice());
        BatterCakeWithEgg withEgg = new BatterCakeWithEgg();
        System.out.println(withEgg.getMsg()+"，价格:"+withEgg.getPrice());
        BatterCakeWithEggAndSau andSau = new BatterCakeWithEggAndSau();
        System.out.println(andSau.getMsg()+"，价格:"+andSau.getPrice());
    }
}
