package com.person.cn.demotestone.designmodel.mementon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 备忘录管理者:负责创建备忘录和获取备忘录
 * @package com.person.cn.demotestone.designmodel.mementon
 * @updateUser
 * @date 15:12 2020/12/17
 */
public class MementoCaretaker {
    private List<ChessmanMemento> mementos = new ArrayList<>();

    public ChessmanMemento getMementos(int i) {
        return mementos.get(i);
    }

    public void setMementos(ChessmanMemento mementos) {
        this.mementos.add(mementos);
    }
}
