package com.person.cn.demotestone.designmodel.mediator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.mediator.two
 * @updateUser
 * @date 18:44 2020/12/17
 */
public class ChatRoom {
    public static void  showMessage(User user,String message){
        System.out.println(user.getName()+"，发送了消息：“"+message+"”");
    }
}
