package com.person.cn.demotestone.designmodel.builder;

/**
 * @author ym.y
 * @description 角色构造器：抽象建造者
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 16:58 2020/12/12
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairsStyle();
    public Actor creatActor(){
        return  actor;
    }
    /**
     * @description   用于判断是否需要构建某个方法
     * @author ym.y
     * @updateUser
     * @date  10:45 2020/12/13
     */
    public  boolean isBareheaded(){
        return false;
    }
}
