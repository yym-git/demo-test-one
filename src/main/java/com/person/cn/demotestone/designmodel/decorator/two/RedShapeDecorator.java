package com.person.cn.demotestone.designmodel.decorator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator.two
 * @updateUser
 * @date 10:58 2020/12/21
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shapeDecorator) {
        super(shapeDecorator);
    }

    @Override
    public void draw() {
        shapeDecorator.draw();
        setRedBorder(shapeDecorator);
    }

    private void setRedBorder(Shape decorator) {
        System.out.println("border color red");
    }
}
