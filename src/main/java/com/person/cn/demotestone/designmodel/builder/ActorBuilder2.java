package com.person.cn.demotestone.designmodel.builder;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 17:23 2020/12/12
 */
public abstract class ActorBuilder2 {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairsStyle();

    public  Actor construct() {
        this.buildCostume();
        this.buildHairsStyle();
        this.buildSex();
        this.buildFace();
        this.buildType();
        return actor;
    }
}
