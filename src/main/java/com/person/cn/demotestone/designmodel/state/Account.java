package com.person.cn.demotestone.designmodel.state;

import lombok.Data;

/**
 * @author ym.y
 * @description 银行账户：环境类
 * @package com.person.cn.demotestone.state
 * @updateUser
 * @date 10:46 2020/12/17
 */
@Data
public class Account {
    //账户状态
    private AccountState state;
    //开户名
    private String owner;
    //账户余额
    private double balance = 0;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        //初始为正常状态
        this.state = new NormalState(this);
        System.out.println(this.owner + "开户成功，初始金额为：" + balance);
        System.out.println("----------------------------------------");
    }

    /**
     * @description 存钱
     * @author ym.y
     * @updateUser
     * @date 11:19 2020/12/17
     */
    public void deposit(double amount) {
        System.out.println(this.owner + "存款" + amount + "元");
        //调用状态对象的deposit方法
        state.deposit(amount);
        System.out.println("现在余额为：" + this.balance);
        System.out.println("现在账户状态为：" + this.state.getClass().getName());
        System.out.println("-----------------------------------------------");
    }


    /**
     * @description 取钱
     * @author ym.y
     * @updateUser
     * @date 11:24 2020/12/17
     */
    public void withdraw(double amount) {
        System.out.println(this.owner + "取款" + amount + "元");
        //调用状态对象的deposit方法
        state.withdraw(amount);
        System.out.println("现在余额为：" + this.balance);
        System.out.println("现在账户状态为：" + this.state.getClass().getName());
        System.out.println("-----------------------------------------------");
    }

    /**
     * @description 计算利息
     * @author ym.y
     * @updateUser
     * @date 11:25 2020/12/17
     */
    public void computeInterest() {
        this.state.computeInterest();
    }
}
