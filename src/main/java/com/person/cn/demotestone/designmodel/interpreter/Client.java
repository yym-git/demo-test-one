package com.person.cn.demotestone.designmodel.interpreter;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 14:10 2020/12/18
 */
public class Client {
    public static void main(String[] args) {
        //将以下句子分为三类：
        //表示方向类节点：上下左右
        //表示距离类节点
        //表示移动速度类：move-移动，run-快速移动
        String instruction ="up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String outString = handler.output();
        System.out.println("解释结果："+outString);
    }
}
