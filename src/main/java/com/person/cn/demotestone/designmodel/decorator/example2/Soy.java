package com.person.cn.demotestone.designmodel.decorator.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:40 2021/3/15
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.5f);
    }
}
