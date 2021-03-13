package com.person.cn.demotestone.designmodel.observer;

/**
 * @author ym.y
 * @description 具体的战队控制中心：具体目标类
 * @package com.person.cn.demotestone.designmodel.observer
 * @updateUser
 * @date 16:57 2020/12/16
 */
public class ConcreteAllyControlCenter  extends  AllyControllerCenter{
    public ConcreteAllyControlCenter(String allyName){
        System.out.println(allyName+"联盟创建成功！");
        System.out.println("------------------");
        this.allyName = allyName;
    }
    @Override
    public void notifyObserver(String name) {
        System.out.println(allyName+"联盟紧急通知，盟友"+name+"遭受敌人袭击！");
        for (Observer  obs : players) {
            if(!(obs.getName().equalsIgnoreCase(name))){
                //调用盟友（除自己以外）的支援方法
                obs.help();
            }
        }
    }
}
