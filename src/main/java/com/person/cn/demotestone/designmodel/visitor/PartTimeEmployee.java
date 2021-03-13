package com.person.cn.demotestone.designmodel.visitor;

import lombok.Data;

/**
 * @author ym.y
 * @description 兼职员工：具体元素
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 10:44 2020/12/18
 */
@Data
public class PartTimeEmployee implements Employee {
    //    姓名
    private String name;
    //    时薪
    private double hourWage;
    //    工作时间
    private int workTime;

    public PartTimeEmployee(String name, double hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this);
    }
}
