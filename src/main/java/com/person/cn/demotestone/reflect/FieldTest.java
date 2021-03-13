package com.person.cn.demotestone.reflect;

import com.person.cn.demotestone.reflect.proxy.Personal;

import java.lang.reflect.Field;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 16:062020/12/2
 */
public class FieldTest {
    public static void main(String[] args) throws Exception {
        Person p  = new Person();
        Class<Personal> personClazz = Personal.class;
        //获取各种访问控制符的成员变量
        Field nameField =  personClazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p,"YeeHu.H.Lee");
        Field ageField = personClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p,12);
        System.out.println(p);
    }
}

class Person{
    private  String  name;
    private  int  age;

    @Override
    public String toString() {
        return "Person[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}