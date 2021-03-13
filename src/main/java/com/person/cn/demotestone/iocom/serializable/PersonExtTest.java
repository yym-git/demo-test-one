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
 * @date 13:012020/12/8
 */
public class PersonExtTest {
    public static void main(String[] args)  throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\extP.txt"));
        PersonExt personExt = new PersonExt("吴栓",1);
        oos.writeObject(personExt);

        System.out.println("开始反序列化....");
        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("D:\\extP.txt"));
        System.out.println("开始反序列化2....");
        PersonExt pt = (PersonExt) ois.readObject();
        System.out.println("开始反序列化3....");
        System.out.println(pt);
    }
}
