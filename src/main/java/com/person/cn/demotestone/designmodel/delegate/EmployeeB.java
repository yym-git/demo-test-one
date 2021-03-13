package com.person.cn.demotestone.designmodel.delegate;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.delegate
 * @updateUser
 * @date 12:16 2020/12/24
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("员工B，开始工作:" + command);
    }
}
