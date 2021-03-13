package com.person.cn.demotestone.designmodel.interpreter;

/**
 * @author ym.y
 * @description And解释：具体的解释节点
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 13:35 2020/12/18
 */
public class AndNode extends AbstractNode {
    //And的左表达式
    private AbstractNode left;
    //And的右表达式
    private AbstractNode right;

    public AndNode(AbstractNode left, AbstractNode rigth) {
        this.left = left;
        this.right = rigth;
    }

    @Override
    public String interpreter() {
        return left.interpreter() + "再" + right.interpreter();
    }
}
