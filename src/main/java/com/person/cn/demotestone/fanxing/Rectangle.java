package com.person.cn.demotestone.fanxing;


/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fx
 * @updateUser
 * @date 11:342020/12/1
 */
public class Rectangle extends Shape {
    @Override
    public void draw(Canvas canvas) {
        System.out.println("把一个矩形画在画布"+canvas+"上");
    }
}
