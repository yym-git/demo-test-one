package com.person.cn.demotestone.designmodel.mementon;

/**
 * @author ym.y
 * @description 模拟象棋悔棋
 * @package com.person.cn.demotestone.designmodel.mementon
 * @updateUser
 * @date 15:13 2020/12/17
 */
public class Client {
    private static int index = -1;
    //备忘录管理者
    private static MementoCaretaker mc = new MementoCaretaker();

    public static void main(String[] args) {
        Chessman chessman = new Chessman("车", 1, 1);
        play(chessman);
        chessman.setY(4);
        play(chessman);
        chessman.setX(5);
        play(chessman);
        undo(chessman, index);
        undo(chessman, index);
        redo(chessman, index);
        redo(chessman, index);
    }

    /**
     * @description 下棋
     * @author ym.y
     * @updateUser
     * @date 15:38 2020/12/17
     */
    public static void play(Chessman chessman) {
        mc.setMementos(chessman.save());
        index++;
        display(chessman);
    }

    /**
     * @description 撤销悔棋
     * @author ym.y
     * @updateUser
     * @date 15:36 2020/12/17
     */
    public static void redo(Chessman chessman, int i) {
        System.out.println("*************撤销悔棋*************");
        index++;
        chessman.restore(mc.getMementos(i + 1));
        display(chessman);
    }

    public static void undo(Chessman chessman, int i) {
        index--;
        System.out.println("***********悔棋****************");
        //撤销到上一个备忘录
        chessman.restore(mc.getMementos(i - 1));
        display(chessman);
    }

    public static void display(Chessman chessman) {
        System.out.println("棋子:" + chessman.getLabel() + ",当前位置:(" + chessman.getX() + "," + chessman.getY() + ")");
    }
}
