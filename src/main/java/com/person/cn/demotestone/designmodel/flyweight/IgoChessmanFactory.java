package com.person.cn.demotestone.designmodel.flyweight;

import java.util.Hashtable;

/**
 * @author ym.y
 * @description 围棋棋子工厂类：享元工厂类，使用单例模式设计
 * @package com.person.cn.demotestone.designmodel.flyweight.one
 * @updateUser
 * @date 15:22 2020/12/18
 */
public class IgoChessmanFactory {
    //使用 Hashtable存储享元对象，充当享元池
    private static Hashtable<String, IgoChessman> ht;

    private IgoChessmanFactory() {
        ht = new Hashtable();
        IgoChessman black, white;
        black = new BlackIgoChessman();
        white = new WhiteIgoChessman();
        ht.put("b", black);
        ht.put("w", white);
    }

    private static class Inner {
        //一旦赋值将不可变更
        private final static IgoChessmanFactory instance = new IgoChessmanFactory();
    }

    public static IgoChessmanFactory getInstance() {
        return Inner.instance;
    }

    public IgoChessman getIgoChessman(String color) {
        return ht.get(color);
    }
}
