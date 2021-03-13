package com.person.cn.demotestone.service;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.service
 * @updateUser
 * @date 13:21 2021/3/3
 */
public class ServiceA {
   private  ServiceB serviceB;

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public ServiceA() {
        System.out.println("创建对象ServiceA");
    }
}
