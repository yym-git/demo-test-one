package com.person.cn.demotestone.designmodel.decorator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.two
 * @updateUser
 * @date 11:07 2020/12/21
 */
public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(circle);
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        circle.draw();

        redCircle.draw();
        redRectangle.draw();
    }
}
