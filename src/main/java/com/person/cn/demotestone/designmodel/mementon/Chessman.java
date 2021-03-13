package com.person.cn.demotestone.designmodel.mementon;

import lombok.Data;

/**
 * @author ym.y
 * @description 象棋棋子类：源发器
 * @package com.person.cn.demotestone.designmodel.mementon
 * @updateUser
 * @date 15:04 2020/12/17
 */
@Data
public class Chessman {
    //象棋子
    private String label;
    private int x;
    private int y;

    public Chessman(String label, int x, int y) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    /**
     * @description 保存状态
     * @author ym.y
     * @updateUser
     * @date 15:08 2020/12/17
     */
    public ChessmanMemento save() {
        return new ChessmanMemento(label, x, y);
    }

    /**
     * @description 恢复状态
     * @author ym.y
     * @updateUser
     * @date 15:10 2020/12/17
     */
    public void restore(ChessmanMemento memento) {
        this.x = memento.getX();
        this.y = memento.getY();
        this.label = memento.getLabel();
    }
}
