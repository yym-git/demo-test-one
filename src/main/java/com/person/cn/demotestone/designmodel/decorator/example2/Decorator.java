package com.person.cn.demotestone.designmodel.decorator.example2;

/**
 * @author ym.y
 * @description 装饰者
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:32 2021/3/15
 */
public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        //被装饰者信息
        return super.getDes()+" "+super.getPrice()+" && "+obj.getDes();
    }
}
