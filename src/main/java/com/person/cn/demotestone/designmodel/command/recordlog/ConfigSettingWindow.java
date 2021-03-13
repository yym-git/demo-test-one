package com.person.cn.demotestone.designmodel.command.recordlog;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 配置文件设置窗口类：请求发送者
 * @package com.person.cn.demotestone.designmodel.command.recordlog
 * @updateUser
 * @date 10:53 2020/12/16
 */
public class ConfigSettingWindow {
    //定义一个集合来存储每次操作时的命令对象
    private List<Command> commands = new ArrayList<>();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * @description 执行配置文件修改命令，同时将命令对象添加到命令集合中
     * @author ym.y
     * @updateUser
     * @date 10:56 2020/12/16
     */
    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    /**
     * @description 记录请求日志，生成日志文件，将命令集合写入文件中
     * @author ym.y
     * @updateUser
     * @date 11:12 2020/12/16
     */
    public void save() {
        FileUtil.writeCommand(commands);
    }

    /**
     * @description 从日志文件中读取命令集合
     * @author ym.y
     * @updateUser
     * @date  11:14 2020/12/16
     */
    public  void  recover(){
      List commands =   FileUtil.readCommand();
      for(Object obj  :  commands ){
          ((Command)obj).execute();
      }
    }

}
