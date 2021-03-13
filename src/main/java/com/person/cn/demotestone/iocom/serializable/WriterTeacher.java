package com.person.cn.demotestone.iocom.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 15:572020/12/5
 */
public class WriterTeacher {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\teacher.txt"))) {
            Person per = new Person("孙悟空",20);
            Teacher t1 = new Teacher("唐僧",per);
            Teacher t2 = new Teacher("须菩提",per);
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
