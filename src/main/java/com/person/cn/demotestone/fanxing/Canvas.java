package com.person.cn.demotestone.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description
 * 虽然Circle、Rectangle是Shape的子类，但是List<Circle>、
 * List<Rectangle>并不是List<Shape>的子类，想要List<Shape>引用
 * List<Circle>、List<Rectangle>对象，需要使用被限制的上限泛型通配符,即：
 * List<? extends Shape>
 *
 * @package com.person.cn.demotestone.fx
 * @updateUser
 * @date 11:352020/12/1
 */
public class Canvas {
    public  void  drawAll(List<? extends Shape> shapes){
        for(Shape s  : shapes){
            s.draw(this);
            //被限制的通配符类型只出不进，因为它并不知道需要添加的元素类型，下面的代码编译报错-
//            shapes.addAll(1,new Circle());
        }
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        Canvas c = new  Canvas();
        c.drawAll(circleList);
    }
}
