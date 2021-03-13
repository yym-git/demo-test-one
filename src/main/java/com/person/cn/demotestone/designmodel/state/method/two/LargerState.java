package com.person.cn.demotestone.designmodel.state.method.two;

/**
 * @author ym.y
 * @description 2倍大小状态类：具体状态类
 * @package com.person.cn.demotestone.state.method.two
 * @updateUser
 * @date 13:08 2020/12/17
 */
public class LargerState implements AbstractState {
    @Override
    public void display() {
        System.out.println("2倍大小状态！");
    }
}
