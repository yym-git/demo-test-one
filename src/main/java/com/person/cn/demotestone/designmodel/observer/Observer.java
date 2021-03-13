package com.person.cn.demotestone.designmodel.observer;

/**
 * @author ym.y
 * @description 抽象观察类
 * @package com.person.cn.demotestone.designmodel.observer
 * @updateUser
 * @date 16:38 2020/12/16
 */
public interface Observer {
    public void setName(String name);

    public String getName();

    //声明支援盟友的方法
    public void help();

    //声明遭受攻击的方法
    //遭受攻击时由指挥中心发送通知
    public void beAttacked(AllyControllerCenter acc);
}
