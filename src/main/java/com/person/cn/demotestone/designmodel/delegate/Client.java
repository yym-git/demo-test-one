package com.person.cn.demotestone.designmodel.delegate;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.delegate
 * @updateUser
 * @date 12:20 2020/12/24
 */
public class Client {
    public static void main(String[] args) {
        new  Boss().command("登录",new Leader());
    }
}
