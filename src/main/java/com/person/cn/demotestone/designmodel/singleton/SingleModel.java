package com.person.cn.demotestone.designmodel.singleton;

/**
 * @author ym.y
 * @description 双重检测(懒汉模式)
 * @package com.person.cn.demotestone.designmodel
 * @updateUser
 * @date 15:03 2020/12/11
 */
public class SingleModel {
    private static volatile SingleModel singleModel;

    private SingleModel() {
    }

    public static SingleModel getInstance() {
        if (singleModel == null) {
            synchronized (SingleModel.class){
                if(singleModel == null){
                    singleModel = new SingleModel();
                }
            }
        }
        return singleModel;
    }
}
