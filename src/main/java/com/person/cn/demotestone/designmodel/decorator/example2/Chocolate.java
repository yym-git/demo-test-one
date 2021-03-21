package com.person.cn.demotestone.designmodel.decorator.example2;

/**
 * @author ym.y
 * @description 具体的调味品（装饰者）
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:38 2021/3/15
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);
    }
}
