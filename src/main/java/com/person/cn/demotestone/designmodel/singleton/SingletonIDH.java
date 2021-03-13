package com.person.cn.demotestone.designmodel.singleton;

/**
 * @author ym.y
 * @description IDO : Initialization on Demand Holder
 * 采用静态内部类的模式，结合了饿汉模式和懒汉模式的优点
 * @package com.person.cn.demotestone.designmodel
 * @updateUser
 * @date 15:25 2020/12/11
 */
public class SingletonIDH {
    private  SingletonIDH(){
        if(HolderClass.singleton != null ){
            throw new RuntimeException("不允许创建多个实例！");
        }
    }
    private  static  class HolderClass{
        private  static  final  SingletonIDH singleton = new SingletonIDH();
    }

    public  static SingletonIDH getInstance(){
        return  HolderClass.singleton;
    }

    public static void main(String[] args) {
        SingletonIDH s1,s2;
        s1= SingletonIDH.getInstance();
        s2= SingletonIDH.getInstance();
        System.out.println(s1==s2);
    }
}
