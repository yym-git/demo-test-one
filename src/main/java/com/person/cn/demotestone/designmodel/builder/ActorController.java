package com.person.cn.demotestone.designmodel.builder;

/**
 * @author ym.y
 * @description 游戏角色创建控制器：指挥者
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:06 2020/12/12
 */
public class ActorController {
    public Actor construct(ActorBuilder ab) {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        if(!ab.isBareheaded()){
            ab.buildHairsStyle();
        }
        return ab.creatActor();
    }
}
