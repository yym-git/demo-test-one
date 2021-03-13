package com.person.cn.demotestone.designmodel.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 员工列表类：对象结构
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 11:07 2020/12/18
 */
public class EmployeeList {
    private List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    public void accept(Department handler) {
        for (Employee emp : list) {
            emp.accept(handler);
        }
    }
}
