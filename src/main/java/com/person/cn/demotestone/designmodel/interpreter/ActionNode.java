package com.person.cn.demotestone.designmodel.interpreter;

/**
 * @author ym.y
 * @description 动作解释节点：具体解释节点
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 13:49 2020/12/18
 */
public class ActionNode extends AbstractNode {
    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    @Override
    public String interpreter() {
        if (("move").equalsIgnoreCase(action)) {
            return "移动";
        } else if (("run").equalsIgnoreCase(action)) {
            return "快速移动";
        } else {
            return "无效指令";
        }
    }
}
