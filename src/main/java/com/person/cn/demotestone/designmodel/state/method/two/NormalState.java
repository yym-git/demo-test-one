package com.person.cn.demotestone.designmodel.state.method.two;

/**
 * @author ym.y
 * @description 正常状态类：具体状态类
 * @package com.person.cn.demotestone.state.method.two
 * @updateUser
 * @date 13:08 2020/12/17
 */
public class NormalState implements AbstractState {
    @Override
    public void display() {
        System.out.println("正常大小状态！");
    }
}
