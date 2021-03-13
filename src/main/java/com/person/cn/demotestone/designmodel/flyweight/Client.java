package com.person.cn.demotestone.designmodel.flyweight;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.flyweight.one
 * @updateUser
 * @date 15:36 2020/12/18
 */
public class Client {
    public static void main(String[] args) {
        IgoChessman black, black2, black3, white, white2;
        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();
        black = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println("black==black2:" + (black == black2));
        System.out.println("black2==black3:" + (black2 == black3));
        white = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("white==white2:" + (white == white2));
        System.out.println("--------------------------------------------");
        //一下代码体现了同一个对象的复用
        //同一颗黑棋子棋子被放置在不同的位置
        black.display(new Coordinates(1, 2));
        black2.display(new Coordinates(2, 1));
        black3.display(new Coordinates(3, 4));
        //同一颗白棋子被放置在不同的位置
        white.display(new Coordinates(2, 5));
        white2.display(new Coordinates(6, 7));
    }
}
