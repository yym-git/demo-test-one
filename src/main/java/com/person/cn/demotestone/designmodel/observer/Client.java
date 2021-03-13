package com.person.cn.demotestone.designmodel.observer;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.observer
 * @updateUser
 * @date 17:04 2020/12/16
 */
public class Client {
    public static void main(String[] args) {
        AllyControllerCenter acc = new ConcreteAllyControlCenter("天墉城");
        Observer player1, player2, player3, player4;
        player1 = new Player("杨过");
        player2 = new Player("令狐冲");
        player3 = new Player("张无忌");
        player4 = new Player("段誉");
        acc.join(player1);
        acc.join(player2);
        acc.join(player3);
        acc.join(player4);
        player1.beAttacked(acc);
        player2.beAttacked(acc);
    }
}
