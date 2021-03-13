package com.person.cn.demotestone.iocom.serializable;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 12:472020/12/8
 */
@Data
public class PersonExt implements Externalizable {
    private String name;
    private  int age;
    public PersonExt(){
        System.out.println("无参构造函数....");
    }
    public PersonExt(String name,int age ){
        System.out.println("有参构造函数....");
        this.age = age;
        this.name =name;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }

}
