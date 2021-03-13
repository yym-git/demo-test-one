package com.person.cn.demotestone.designmodel.builder;

/**
 * @author ym.y
 * @description 恶魔角色建造器：具体建造器
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:04 2020/12/12
 */
public class DevilBuilder2 extends ActorBuilder2 {
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairsStyle() {
        actor.setHairsStyle("光头");
    }
}
