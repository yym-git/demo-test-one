package com.person.cn.demotestone.designmodel.command.undo;

/**
 * @author ym.y
 * @description 计算器类：请求发送者
 * @package com.person.cn.demotestone.designmodel.command.undo
 * @updateUser
 * @date 10:07 2020/12/16
 */
public class CalculatorForm {
    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void compute(int value) {
        int i = command.execute(value);
        System.out.println("执行运行，计算结果为：" + i);
    }

    /**
     * @description 撤销操作
     * @author ym.y
     * @updateUser
     * @date 10:11 2020/12/16
     */
    public void undo() {
        int i = command.undo();
        System.out.println("执行撤销，运算结果为：" + i);
    }
}
