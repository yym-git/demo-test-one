package com.person.cn.demotestone.designmodel.decorator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.two
 * @updateUser
 * @date 10:54 2020/12/21
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape:circle");
    }
}
