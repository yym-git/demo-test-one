package com.person.cn.demotestone.designmodel.state.method.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.state.method.two
 * @updateUser
 * @date 13:20 2020/12/17
 */
public class Client {
    public static void main(String[] args) {
        Screen screen = new Screen();
       for(int i =0; i< 5; i++){
           screen.onClick();
       }
    }
}
