package com.person.cn.demotestone.iocom.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.serializable
 * @updateUser
 * @date 15:552020/12/5
 */
@Data
public class Teacher implements Serializable {
    private String name;
    private Person  student;
    public  Teacher(String name,Person  student){
        this.name = name;
        this.student = student;
    }
}
