package com.person.cn.demotestone.designmodel.command.recordlog;

/**
 * @author ym.y
 * @description 增加属性命令类：具体的命令类
 * @package com.person.cn.demotestone.designmodel.command.rrecordlog
 * @updateUser
 * @date 10:38 2020/12/16
 */
public class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
        configOperator.insert(args);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }
}
