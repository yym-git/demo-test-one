package com.person.cn.demotestone.designmodel.observer;

/**
 * @author ym.y
 * @description 战队成员：具体的观察者类
 * @package com.person.cn.demotestone.designmodel.observer
 * @updateUser
 * @date 16:43 2020/12/16
 */
public class Player implements Observer {
    private String name;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void help() {
        System.out.println("坚持住，"+this.name+"前往支援！");
    }

    /**
     * @description   遭受攻击的人通过指挥中心发送消息给其他盟友
     * @author ym.y
     * @updateUser
     * @date  17:16 2020/12/16
     */
    @Override
    public void beAttacked(AllyControllerCenter acc) {
        System.out.println(this.name+",遭受攻击，请求支援！");
        //由指挥中心将遭受攻击的消息通知给其他战队成员
        acc.notifyObserver(this.name);
    }
}
