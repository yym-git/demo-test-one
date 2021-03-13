package com.person.cn.demotestone.iocom.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author ym.y
 * @description 反序列化teacher对象
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 16:132020/12/5
 */
public class ReaderTeacher {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\teacher.txt"))) {
            Teacher t1= (Teacher) ois.readObject();
            Teacher t2= (Teacher) ois.readObject();
            Person per = (Person)ois.readObject();
            Teacher t3 = (Teacher)ois.readObject();
            //以下全部是true
            System.out.println("t1.getStudent()== per: "+(t1.getStudent() == per));
            System.out.println("t2.getStudent()== per: "+(t2.getStudent() == per));
            System.out.println("t2==t3: "+(t2 == t3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
