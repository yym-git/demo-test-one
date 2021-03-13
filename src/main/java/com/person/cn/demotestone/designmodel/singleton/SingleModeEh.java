package com.person.cn.demotestone.designmodel.singleton;

/**
 * @author ym.y
 * @description 饿汉模式
 * @package com.person.cn.demotestone.designmodel
 * @updateUser
 * @date 15:21 2020/12/11
 */
public class SingleModeEh {
    private  static final  SingleModeEh singleTon = new SingleModeEh();
    private SingleModeEh(){

    }
    public  static  SingleModeEh getInstance(){
        return singleTon;
    }
}
