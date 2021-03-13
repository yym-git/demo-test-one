package com.person.cn.demotestone.designmodel.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description 客户端
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:15 2020/12/12
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        ActorBuilder actorBuilder = new AngleBuilder();
        Actor actor = new ActorController().construct(actorBuilder);
        log.info(actor.getType() + "的外观：");
        log.info("性别：" + actor.getSex());
        log.info("面容：" + actor.getFace());
        log.info("服饰：" + actor.getCostume());
        log.info("发型：" + actor.getHairsStyle());
    }
}
