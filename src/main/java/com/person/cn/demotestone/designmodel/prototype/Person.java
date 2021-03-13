package com.person.cn.demotestone.designmodel.prototype;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 14:17 2020/12/12
 */
@Data
public class Person implements Serializable {
    private  String name;
    private  int age;
    public  Person(String name ,int age){
        this.name = name;
        this.age = age;
    }
}
