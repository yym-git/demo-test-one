package com.person.cn.demotestone.service;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.service
 * @updateUser
 * @date 13:21 2021/3/3
 */
public class ServiceB {
    private  ServiceA serviceA;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceB() {
        System.out.println("初始化serviceB");
    }
}
