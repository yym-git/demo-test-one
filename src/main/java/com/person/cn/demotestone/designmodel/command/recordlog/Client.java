package com.person.cn.demotestone.designmodel.command.recordlog;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.command.recordlog
 * @updateUser
 * @date 11:17 2020/12/16
 */
public class Client {
    public static void main(String[] args) {
        ConfigSettingWindow csw = new ConfigSettingWindow();
        Command command;
        ConfigOperator co = new ConfigOperator();

        //4次对配置文件的更改
        command = new InsertCommand("添加");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("首页");

        command = new InsertCommand("添加");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("端口号");

        command = new ModifyCommand("修改");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("网站首页");

        command = new ModifyCommand("修改");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("端口号");

        System.out.println("----------------------------------------");
        System.out.println("保存配置文件");
        csw.save();
        System.out.println("----------------------------------------");
        System.out.println("恢复配置文件");
        csw.recover();
    }
}
