package com.person.cn.demotestone.designmodel.interpreter;

/**
 * @author ym.y
 * @description 简单句子解释：非终结表达式
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 13:41 2020/12/18
 */
public class SentenceNode extends AbstractNode {
    //方向
    private AbstractNode direction;
    //移动
    private AbstractNode action;
    //距离
    private AbstractNode distance;

    public SentenceNode(AbstractNode direction, AbstractNode action, AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    @Override
    public String interpreter() {
        return direction.interpreter() + action.interpreter() + distance.interpreter();
    }
}
