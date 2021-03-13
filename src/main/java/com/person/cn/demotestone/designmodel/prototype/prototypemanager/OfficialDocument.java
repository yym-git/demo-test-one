package com.person.cn.demotestone.designmodel.prototype.prototypemanager;

/**
 * @author ym.y
 * @description 抽象公文接口，提供clone方法的实现，将业务方法申明为抽象方法
 * @package com.person.cn.demotestone.designmodel.prototype.prototypemanager
 * @updateUser
 * @date 14:37 2020/12/12
 */
public interface OfficialDocument extends Cloneable{
    public OfficialDocument clone();
    public void  display();
}
