package com.person.cn.demotestone.designmodel.state;

/**
 * @author ym.y
 * @description 正常状态：具体状态类
 * @package com.person.cn.demotestone.state
 * @updateUser
 * @date 10:50 2020/12/17
 */
public class NormalState extends AccountState {
    public NormalState(Account acc) {
        this.acc = acc;
    }

    public NormalState(AccountState state) {
        this.acc = state.acc;
    }

    /**
     * @description 存钱
     * @author ym.y
     * @updateUser
     * @date 10:54 2020/12/17
     */
    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance() + amount);
        this.stateCheck();
    }

    /**
     * @description 取钱
     * @author ym.y
     * @updateUser
     * @date 10:55 2020/12/17
     */
    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance() - amount);
        this.stateCheck();
    }

    /**
     * @description 计算利息
     * @author ym.y
     * @updateUser
     * @date 10:55 2020/12/17
     */
    @Override
    public void computeInterest() {
        System.out.println("正常状态，无需支付利息！");
    }

    /**
     * @description 状态检查（状态转换）
     * @author ym.y
     * @updateUser
     * @date 10:55 2020/12/17
     */
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
