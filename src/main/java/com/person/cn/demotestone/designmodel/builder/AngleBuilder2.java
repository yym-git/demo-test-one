package com.person.cn.demotestone.designmodel.builder;

/**
 * @author ym.y
 * @description 天使角色建造器：具体建造器
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:03 2020/12/12
 */
public class AngleBuilder2 extends ActorBuilder2 {
    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("美丽");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("白裙");
    }

    @Override
    public void buildHairsStyle() {
        actor.setHairsStyle("长发飘飘");
    }
}
