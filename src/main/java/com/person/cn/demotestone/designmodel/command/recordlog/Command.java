package com.person.cn.demotestone.designmodel.command.recordlog;

import java.io.Serializable;

/**
 * @author ym.y
 * @description抽象命令类
 * @package com.person.cn.demotestone.designmodel.command.rrecordlog
 * @updateUser
 * @date 10:32 2020/12/16
 */
public abstract class Command implements Serializable {
    //维持对接收者对象的引用
    protected ConfigOperator configOperator;
    //命令的名称
    protected String name;
    //命令参数
    protected String args;

    public Command(String name) {
        this.name = name;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    //声明两个抽象方法
    public abstract void execute();

    public abstract void execute(String args);
}
