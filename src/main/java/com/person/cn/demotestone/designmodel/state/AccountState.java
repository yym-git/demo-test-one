package com.person.cn.demotestone.designmodel.state;

/**
 * @author ym.y
 * @description 抽象状态类
 * @package com.person.cn.demotestone.state
 * @updateUser
 * @date 10:39 2020/12/17
 */
public abstract class AccountState {
    //银行账号类
    protected Account acc;

    //存款
    public abstract void deposit(double  amount);

    //取钱
    public abstract void withdraw(double  amount);

    //计算利息
    public abstract void computeInterest();

    //状态检查
    public abstract void stateCheck();

}
