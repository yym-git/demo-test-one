package com.person.cn.demotestone.designmodel.command.undo;

/**
 * @author ym.y
 * @description 具体的命令类
 * @package com.person.cn.demotestone.designmodel.command.undo
 * @updateUser
 * @date 10:04 2020/12/16
 */
public class AddCommand extends AbstractCommand {
    private Adder adder = new Adder();
    private int value;

    @Override
    public int execute(int value) {
        this.value = value;
        return adder.add(value);
    }

    @Override
    public int undo() {
        return adder.add(-value);
    }
}
