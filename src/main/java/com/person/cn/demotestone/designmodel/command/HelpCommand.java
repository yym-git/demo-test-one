package com.person.cn.demotestone.designmodel.command;

/**
 * @author ym.y
 * @description 帮助命令类：具体命令类
 * @package com.person.cn.demotestone.designmodel.command
 * @updateUser
 * @date 16:42 2020/12/15
 */
public class HelpCommand extends Command {
    //维持对请求接收者的引用
    private HelpHandler helpHandler;

    public HelpCommand() {
        helpHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        helpHandler.display();
    }
}
