package com.person.cn.demotestone.designmodel.delegate;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.delegate
 * @updateUser
 * @date 12:14 2020/12/24
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("员工A，开始工作：" + command);
    }
}
