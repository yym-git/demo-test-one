package com.person.cn.demotestone.designmodel.visitor;

import lombok.Data;

/**
 * @author ym.y
 * @description 全职员工：具体元素
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 10:36 2020/12/18
 */
@Data
public class FullTimeEmployee implements Employee {
    //    员工姓名
    private String name;
    //   员工周薪
    private double weeklyWage;
    //    工作时长
    private int workTime;

    public FullTimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(Department handler) {
        //调用访问者的访问方法
        handler.visit(this);
    }
}
