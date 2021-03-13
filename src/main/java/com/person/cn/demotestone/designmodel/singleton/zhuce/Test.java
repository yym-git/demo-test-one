package com.person.cn.demotestone.designmodel.singleton.zhuce;

import com.person.cn.demotestone.iocom.serializable.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.singleton.zhuce
 * @updateUser
 * @date 17:41 2020/12/23
 */
public class Test {
    public static void main(String[] args) {


    }
    public static void  serializable() {
        EnumSingleton p = null;
        Person person = new Person("zhangsan", 12);
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(person);
        //序列化
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\hh.txt"));
            oos.writeObject(enumSingleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //反序列化
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("D:\\hh.txt"));
            p = (EnumSingleton) oos.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p == enumSingleton);
        Person p1 = (Person)p.getData();
        Person p2 = (Person)enumSingleton.getData();
        System.out.println("p1:"+p1.getName());
        System.out.println("p2:"+p2.getName());
    }

    public static EnumSingleton serializable2() {

        return null;
    }
}
