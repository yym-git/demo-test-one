package com.person.cn.demotestone.iocom.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 12:072020/12/8
 */
public class SerializablePerson2 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\hh.txt"));
        Person p = new Person("gg", 12);
        oos.writeObject(p);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\hh.txt"));
        ArrayList<Object> person = ((ArrayList) ois.readObject());
        System.out.println("===========反序列化结果===="+person);

    }
}
