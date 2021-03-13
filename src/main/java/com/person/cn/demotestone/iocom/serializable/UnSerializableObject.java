package com.person.cn.demotestone.iocom.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author ym.y
 * @description 反序列化对象
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 14:592020/12/5
 */
public class UnSerializableObject {
    public static void main(String[] args) {
        try(ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("D:\\object.txt"))) {
           Person p =  (Person) ois.readObject();
            System.out.println("名字："+p.getName()+"\n年龄："+p.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
