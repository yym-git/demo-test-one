package com.person.cn.demotestone.iocom.serializable;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author ym.y
 * @description 可序列化类
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 14:512020/12/5
 */
@Data
public class Person implements Serializable{
    private String name;
    private  int age;
    public Person(String name,int age ){
        System.out.println("有参构造函数....");
        this.age = age;
        this.name =name;
    }

    /**
     * @description  序列化时自动调用该方法
     * @author ym.y
     * @updateUser
     * @date  12:28 2020/12/8
     */
//    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
//        System.out.println("序列化时自动调用的方法.............");
//        out.writeObject(new StringBuffer(name).reverse());
//        out.writeInt(age);
//    }

    /**
     * @description  反序列化时自动调用该方法
     * @author ym.y
     * @updateUser
     * @date  12:28 2020/12/8
     */
//    private void readObject(java.io.ObjectInputStream inp) throws IOException,ClassNotFoundException{
//        System.out.println("反序列化时自动调用的方法.............");
//        this.name = ((StringBuffer)inp.readObject()).reverse().toString();
//        this.age = inp.readInt();
//    }

   /**
    * @description
    * @author ym.y
    * @updateUser
    * @date  12:36 2020/12/8
    */
//   private Object writeReplace() throws ObjectStreamException{
//       System.out.println("调用了writeReplace方法.......");
//       ArrayList<Object> list = new ArrayList<>();
//       list.add(name);
//       list.add(age);
//       return list;
//    }


}
