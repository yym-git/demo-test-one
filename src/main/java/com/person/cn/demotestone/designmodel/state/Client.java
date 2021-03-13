package com.person.cn.demotestone.designmodel.state;

/**
 * @author ym.y
 * @description 客户端类
 * 场景描述：
 *  账户余额>=0时，为正常状态，正常状态，允许存取款；
 *  账户余额-2000>= 账户余额  < 0时，透支状态，允许存取款，不允取款；
 *  账户余额<-2000时，账户受限，不允许取款，但允许存款，同时计算利息
 * @package com.person.cn.demotestone.state
 * @updateUser
 * @date 11:26 2020/12/17
 */
public class Client {
    public static void main(String[] args) {
        Account account = new Account("段誉", 0.0);
        account.deposit(100);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(4000);
        account.withdraw(1000);
        account.computeInterest();
    }
}
