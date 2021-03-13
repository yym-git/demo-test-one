package com.person.cn.demotestone.designmodel.state;

/**
 * @author ym.y
 * @description 受限状态：具体状态类
 * @package com.person.cn.demotestone.state
 * @updateUser
 * @date 11:01 2020/12/17
 */
public class RestrictedState extends AccountState {

    public RestrictedState(AccountState state) {
        this.acc = state.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance() + amount);
        this.stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("账号受限，取款失败！");
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    @Override
    public void stateCheck() {
        if (acc.getBalance() > -2000 && acc.getBalance() < 0) {
            //进入透支状态
            acc.setState(new OverdraftSate(this));
        } else if (acc.getBalance()<=-2000) {
            //进入受限状态
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance() >= 0){
            acc.setState(new NormalState(this));
        }
    }
}
