package com.person.cn.demotestone.designmodel.flyweight;

/**
 * @author ym.y
 * @description 围棋棋子：抽象享元类
 * @package com.person.cn.demotestone.designmodel.flyweight.one
 * @updateUser
 * @date 15:17 2020/12/18
 */
public abstract class IgoChessman {
    public abstract String getColor();

    public void display(Coordinates coordinates) {
        System.out.println("棋子颜色：" + this.getColor()
                + "，棋子位置：（" + coordinates.getX() + "," + coordinates.getY() + ")");
    }
}
