package com.person.cn.demotestone.designmodel.mementon;

import lombok.Data;

/**
 * @author ym.y
 * @description 象棋棋子备忘录
 * @package com.person.cn.demotestone.designmodel.mementon
 * @updateUser
 * @date 15:06 2020/12/17
 */
@Data
public class ChessmanMemento {
    //象棋子
    private String label;
    private int x;
    private int y;

    public ChessmanMemento(String label, int x, int y) {
        this.x = x;
        this.y = y;
        this.label = label;
    }
}
