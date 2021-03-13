package com.person.cn.demotestone.designmodel.command.undo;

/**
 * @author ym.y
 * @description 加法类：请求接收者
 * @package com.person.cn.demotestone.designmodel.command.undo
 * @updateUser
 * @date 10:00 2020/12/16
 */
public class Adder {
    private int num = 0;
    /**
     * @description   加法操作
     * @author ym.y
     * @updateUser
     * @date  10:01 2020/12/16
     */
    public  int  add(int value){
        num  = num + value;
        return num ;
    }
}
