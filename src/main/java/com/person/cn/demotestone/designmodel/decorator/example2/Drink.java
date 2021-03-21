package com.person.cn.demotestone.designmodel.decorator.example2;

import lombok.Data;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.example2
 * @updateUser
 * @date 22:24 2021/3/15
 */
@Data
public abstract class Drink {
    public  String des;
    private  float price = 0.0f;

    //计算费用抽象方法
    //计算调料的费用
    public abstract float cost();
}
