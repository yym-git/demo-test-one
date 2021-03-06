package com.person.cn.demotestone.designmodel.interpreter;

/**
 * @author ym.y
 * @description 方向解释节点：具体的解释节点
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 13:44 2020/12/18
 */
public class DirectionNode extends AbstractNode {
    private String direction;

    public DirectionNode(String direction) {
        this.direction = direction;
    }

    @Override
    public String interpreter() {

        if ("up".equalsIgnoreCase(direction)) {
            return "向上";
        } else if ("down".equalsIgnoreCase(direction)) {
            return "向下";
        } else if ("left".equalsIgnoreCase(direction)) {
            return "向左";
        } else if ("right".equalsIgnoreCase(direction)) {
            return "向右";
        } else {
            return "指令错误";
        }
    }
}
