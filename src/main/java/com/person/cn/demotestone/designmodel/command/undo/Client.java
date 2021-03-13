package com.person.cn.demotestone.designmodel.command.undo;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.command.undo
 * @updateUser
 * @date 10:06 2020/12/16
 */
public class Client {
    public static void main(String[] args) {
        CalculatorForm form = new CalculatorForm();
        AbstractCommand command = new AddCommand();
        form.setCommand(command);
        form.compute(10);
        form.compute(5);
        form.compute(10);
        form.undo();
        form.undo();
    }
}
