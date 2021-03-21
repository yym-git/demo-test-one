package com.person.cn.demotestone.designmodel.decorator.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:39 2021/3/15
 */
public class Mike extends Decorator {
    public Mike(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.f);
    }
}
