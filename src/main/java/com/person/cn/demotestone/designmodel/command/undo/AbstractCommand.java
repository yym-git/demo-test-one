package com.person.cn.demotestone.designmodel.command.undo;

/**
 * @author ym.y
 * @description 抽象命令类
 * @package com.person.cn.demotestone.designmodel.command.undo
 * @updateUser
 * @date 10:02 2020/12/16
 */
public abstract class AbstractCommand {
    public abstract int execute(int value);
    //声明撤销方法
    public abstract  int  undo();
}
