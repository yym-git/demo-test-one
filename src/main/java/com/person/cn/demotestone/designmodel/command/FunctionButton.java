package com.person.cn.demotestone.designmodel.command;

/**
 * @author ym.y
 * @description 功能键类：请求发送者
 * @package com.person.cn.demotestone.designmodel.command
 * @updateUser
 * @date 16:49 2020/12/15
 */
public class FunctionButton {
    //功能键名称
    private String name;
    //维持一个抽象命令对象的引用
    private Command command;

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * @description 为功能键设置命令
     * @author ym.y
     * @updateUser
     * @date 16:53 2020/12/15
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * @description 发送请求的方法
     * @author ym.y
     * @updateUser
     * @date 16:54 2020/12/15
     */
    public void onClick() {
        command.execute();
    }
}
