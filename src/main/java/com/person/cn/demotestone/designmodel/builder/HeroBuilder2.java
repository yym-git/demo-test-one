package com.person.cn.demotestone.designmodel.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description 英雄角色建造器：具体建造器
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:03 2020/12/12
 */
@Slf4j
public class HeroBuilder2 extends ActorBuilder2 {
    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairsStyle() {
        actor.setHairsStyle("飘逸");
    }
}
