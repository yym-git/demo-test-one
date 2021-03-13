package com.person.cn.demotestone.designmodel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 战队控制中心类：抽象层目标类
 * @package com.person.cn.demotestone.designmodel.observer
 * @updateUser
 * @date 16:41 2020/12/16
 */
public abstract class AllyControllerCenter {
    //战队名称
    protected String allyName;
    //战队成员
    protected List<Observer> players = new ArrayList<>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    /**
     * @description 加入战队方法
     * @author ym.y
     * @updateUser
     * @date 16:51 2020/12/16
     */
    public void join(Observer obs) {
        System.out.println("欢迎‘" + obs.getName() + "’加入‘" + this.allyName + "’联盟！");
        players.add(obs);
    }

    /**
     * @description 退出联盟方法
     * @author ym.y
     * @updateUser
     * @date 16:52 2020/12/16
     */
    public void quit(Observer obs) {
        System.out.println("很遗憾，" + obs.getName() + "离开了" + this.allyName + "联盟！");
    }

    //声明抽象通知方法
    public abstract void notifyObserver(String name);
}
