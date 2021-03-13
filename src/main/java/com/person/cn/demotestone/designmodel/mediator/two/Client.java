package com.person.cn.demotestone.designmodel.mediator.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.mediator.two
 * @updateUser
 * @date 18:48 2020/12/17
 */
public class Client {
    public static void main(String[] args) {
        User user = new User("张三");
        user.sendMessage("你好，我是张三");
    }
}
