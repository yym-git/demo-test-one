package com.person.cn.demotestone.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ym.y
 * @description 反序列化破坏单列
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 17:00 2020/12/23
 */
public class SerializableTest {
    public static void main(String[] args) {
        LazySimpleSingleton s1 =null;
        LazySimpleSingleton s2  = LazySimpleSingleton.getInstance();
        FileOutputStream fos  = null;
        try {
            fos=  new FileOutputStream("D:\\hh.txt");
            ObjectOutputStream oos  = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("D:\\hh.txt"));
            //反序列化的对象
            s1 = (LazySimpleSingleton)ois.readObject();
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
