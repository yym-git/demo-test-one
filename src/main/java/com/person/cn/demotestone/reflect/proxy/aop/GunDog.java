package com.person.cn.demotestone.reflect.proxy.aop;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect.proxy.aop
 * @updateUser
 * @date 17:272020/12/2
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("这是一只猎狗");
    }

    @Override
    public void run() {
        System.out.println("奔跑速度很快");
    }
}
