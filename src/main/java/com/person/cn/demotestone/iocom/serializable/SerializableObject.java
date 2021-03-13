package com.person.cn.demotestone.iocom.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author ym.y
 * @description 序列化person对象
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 14:532020/12/5
 */
public class SerializableObject {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("D:\\object.txt"))) {
            Person p  = new Person("战神",110000);
            oos.writeObject(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
