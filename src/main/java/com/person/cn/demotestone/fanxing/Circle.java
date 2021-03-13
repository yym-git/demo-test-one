package com.person.cn.demotestone.fanxing;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fx
 * @updateUser
 * @date 11:322020/12/1
 */
public class Circle extends  Shape {
    @Override
    public void draw(Canvas canvas) {
        System.out.println("在画布"+canvas + "上画一个圆");
    }
}
