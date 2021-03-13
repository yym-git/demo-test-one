package com.person.cn.demotestone.designmodel.decorator.three.act;

/**
 * @author ym.y
 * @description 煎饼加蛋
 * @package com.person.cn.demotestone.designmodel.decorator.three
 * @updateUser
 * @date 14:12 2020/12/24
 */
public class BatterCakeWithEgg extends BatterCake {
    @Override
    public String getMsg() {
        return super.getMsg()+"加1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+1;
    }
}
