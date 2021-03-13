package com.person.cn.demotestone.designmodel.template;

/**
 * @author ym.y
 * @description 账户类：抽象类
 * @package com.person.cn.demotestone.designmodel.template
 * @updateUser
 * @date 14:15 2020/12/17
 */
public abstract class Account {
    //声明计算利息的抽象方法
    public abstract void calculateInterest();

    /**
     * @description 校验账户密码方法
     * 基本方法-具体方法
     * @author ym.y
     * @updateUser
     * @date 14:16 2020/12/17
     */
    public boolean validate(String uerName, String password) {
        System.out.println("账号：" + uerName + ",密码:" + password);
        if (("张无忌").equalsIgnoreCase(uerName) && ("123456").equalsIgnoreCase(password)) {
            return true;
        }
        return false;
    }

    /**
     * @description 具体方法-基本方法
     * @author ym.y
     * @updateUser
     * @date 14:21 2020/12/17
     */
    public void display() {
        System.out.println("显示利息！");
    }

    /**
     * @description 模板方法：调用基本方法
     * @author ym.y
     * @updateUser
     * @date 14:25 2020/12/17
     */
    public void handle(String userName, String password) {
        if (!this.validate(userName, password)) {
            System.out.println("账户名或密码错误！");
            return;
        }
        calculateInterest();
        display();
    }
}

