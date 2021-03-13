package com.person.cn.demotestone.designmodel.interpreter;

/**
 * @author ym.y
 * @description 距离解释节点：具体的解释节点
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 13:51 2020/12/18
 */
public class DistanceNode extends AbstractNode {
    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    @Override
    public String interpreter() {
        return this.distance;
    }
}
