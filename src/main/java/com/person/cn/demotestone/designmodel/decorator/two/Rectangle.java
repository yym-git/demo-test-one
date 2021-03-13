package com.person.cn.demotestone.designmodel.decorator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.two
 * @updateUser
 * @date 10:53 2020/12/21
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape:Rectangle");
    }
}
