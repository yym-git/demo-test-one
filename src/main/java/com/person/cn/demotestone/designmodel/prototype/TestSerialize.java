package com.person.cn.demotestone.designmodel.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 14:19 2020/12/12
 */
public class TestSerialize {
    public static void main(String[] args) throws Exception {
        Person person = new Person("hanf", 12);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(person);
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Person person2 = (Person) ois.readObject();
        System.out.println(person == person2);

    }
}
