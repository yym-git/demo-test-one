package com.person.cn.demotestone.designmodel.template;

/**
 * @author ym.y
 * @description 活期账户类
 * @package com.person.cn.demotestone.designmodel.template
 * @updateUser
 * @date 14:26 2020/12/17
 */
public class CurrentAccount extends  Account {
    /**
     * @description   覆盖父类的抽象方法
     * @author ym.y
     * @updateUser
     * @date  14:27 2020/12/17
     */
    @Override
    public void calculateInterest() {
        System.out.println("按活期利率计算利息！");
    }
}
