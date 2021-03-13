package com.person.cn.demotestone.designmodel.command;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.command
 * @updateUser
 * @date 17:04 2020/12/15
 */
public class Client {
    public static void main(String[] args) {
        //创建两个功能接口
        FunctionButton fb1,fb2;
        fb1=new FunctionButton("最小化窗口");
        fb2 = new FunctionButton("帮助文档");
        //创建两个命令
        Command cmd1,cmd2;
        cmd1= new MinimizeCommand();
        cmd2 = new HelpCommand();
        //为功能键设置命令
        fb1.setCommand(cmd1);
        fb2.setCommand(cmd2);
        //模拟点击按钮
        fb1.onClick();
        fb2.onClick();
        System.out.println("===================================");
        //为功能窗口添加功能键
        FBSettingWindow fbs  = new FBSettingWindow("功能键设置窗口");
        fbs.addFunctionButton(fb1);
        fbs.addFunctionButton(fb2);
        //显示功能窗口
        fbs.display();
    }
}
