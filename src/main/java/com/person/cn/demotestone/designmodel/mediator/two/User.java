package com.person.cn.demotestone.designmodel.mediator.two;

import lombok.Data;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.mediator.two
 * @updateUser
 * @date 18:44 2020/12/17
 */
@Data
public class User {
    private  String name;
    private String sendMessage;
    public User(String name){
        this.name = name;
    }
    public  void  sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
