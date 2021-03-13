package com.person.cn.demotestone.iocom.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 16:252020/12/5
 */
public class SerializableMutable {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\mutable.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\mutable.txt"))
        ) {
            Person per = new Person("孙悟空", 500);
            //序列化低、第一次
            oos.writeObject(per);
            per.setName("猪八戒");
            //序列化第二次
            oos.writeObject(per);
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            // true
            System.out.println("p1 == p2 :" + (p1 == p2));
            //name===孙悟空
            System.out.println("name===" + p2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
