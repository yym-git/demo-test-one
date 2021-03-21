package com.person.cn.demotestone.designmodel.bridge.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.bridge.example2
 * @updateUser
 * @date 20:50 2021/3/15
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机来电");
    }
}
