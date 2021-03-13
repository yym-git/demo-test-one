package com.person.cn.demotestone.designmodel.decorator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.two
 * @updateUser
 * @date 10:55 2020/12/21
 */
public class ShapeDecorator implements Shape {
    protected Shape shapeDecorator;

    public ShapeDecorator(Shape shapeDecorator) {
        this.shapeDecorator = shapeDecorator;
    }

    @Override
    public void draw() {
        shapeDecorator.draw();
    }
}
