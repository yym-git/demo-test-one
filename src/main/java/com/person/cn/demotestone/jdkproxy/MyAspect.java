package com.person.cn.demotestone.jdkproxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.jdkproxy
 * @updateUser
 * @date 12:53 2021/1/27
 */
public class MyAspect {
    public void check_Permissions(){
        System.out.println("模拟检查权限....");
    }
    public void log(){
        System.out.println("模拟记录日志.....");
    }
}
