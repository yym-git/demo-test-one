package com.person.cn.demotestone.designmodel.command;


/**
 * @author ym.y
 * @description 最小化命令：具体命令
 * @package com.person.cn.demotestone.designmodel.command
 * @updateUser
 * @date 16:45 2020/12/15
 */
public class MinimizeCommand extends Command {
    //维持对请求接受者的引用
    private WindowHandler windowHandler;

    public MinimizeCommand() {
        windowHandler = new WindowHandler();
    }

    @Override
    public void execute() {
        windowHandler.minimize();
    }
}
