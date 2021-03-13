package com.person.cn.demotestone.designmodel.decorator.three;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:34 2020/12/24
 */
public class Client {
    public static void main(String[] args) {
        BatterCake batterCake;
        batterCake = new BaseBatterCake();
        batterCake =new EggDecorator(batterCake);
        batterCake = new SausageDecorator(batterCake);
        System.out.println(batterCake.getMsg()+",价格："+batterCake.getPrice());
    }
}
