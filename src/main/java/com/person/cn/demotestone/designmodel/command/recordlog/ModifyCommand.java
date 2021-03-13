package com.person.cn.demotestone.designmodel.command.recordlog;


/**
 * @author ym.y
 * @description 修改命令类：具体命令
 * @package com.person.cn.demotestone.designmodel.command
 * @updateUser
 * @date 10:42 2020/12/16
 */
public class ModifyCommand extends Command {

    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
        configOperator.modify(this.args);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.modify(args);
    }
}
