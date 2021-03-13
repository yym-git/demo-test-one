package com.person.cn.demotestone.designmodel.singleton.zhuce;

/**
 * @author ym.y
 * @description 枚举类单例模式
 * @package com.person.cn.demotestone.designmodel.singleton.zhuce
 * @updateUser
 * @date 17:38 2020/12/23
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private  EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
