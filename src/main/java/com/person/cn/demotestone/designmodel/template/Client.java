package com.person.cn.demotestone.designmodel.template;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.template
 * @updateUser
 * @date 14:29 2020/12/17
 */
public class Client {
    public static void main(String[] args) {
        Account currentAcc,savingAcc;
        currentAcc = new CurrentAccount();
        currentAcc.handle("张无忌","123456");
        savingAcc = new SavingAccount();
        savingAcc.handle("张无忌","123456");
    }
}
