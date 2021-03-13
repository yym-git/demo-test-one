package com.person.cn.demotestone.designmodel.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:15 2020/12/12
 */
@Slf4j
public class Client2 {
    public static void main(String[] args) {
        Actor actor = new AngleBuilder2().construct();
        log.info(actor.getType() + "的外观：");
        log.info("性别：" + actor.getSex());
        log.info("面容：" + actor.getFace());
        log.info("服饰：" + actor.getCostume());
        log.info("发型：" + actor.getHairsStyle());
    }
}
