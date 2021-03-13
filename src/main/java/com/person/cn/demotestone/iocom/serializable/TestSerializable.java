package com.person.cn.demotestone.iocom.serializable;

import com.person.cn.demotestone.designmodel.command.undo.CalculatorForm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 17:10 2020/12/23
 */
public class TestSerializable {
    public static void main(String[] args) {
        Person p1 = serializable();
        Person p2 = deSerializable();
        System.out.println("p1==p2:"+(p1==p2));
        System.out.println("p1:"+p1.getName()+","+p1.getAge());
        System.out.println("p2:"+p2.getName()+","+p2.getAge());

    }

    public static Person serializable() {
        Person person = new Person("zhangsan", 12);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\hh.txt"));
            oos.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public static Person deSerializable() {
        Person person = new Person("zhangsan", 12);
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("D:\\hh.txt"));
            Person p = (Person) oos.readObject();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
