package com.person.cn.demotestone.designmodel.visitor;

/**
 * @author ym.y
 * @description 财务部门类：具体的访问者
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 10:50 2020/12/18
 */
public class FADepartment extends Department {
    /**
     * @description 财务部门对全职员工的访问
     * @author ym.y
     * @updateUser
     * @date 10:51 2020/12/18
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weeklyWage = employee.getWeeklyWage();
        if (workTime > 40) {
            weeklyWage = weeklyWage + (workTime - 40) * 100;
        } else if (workTime < 40) {
            weeklyWage = weeklyWage - (40 - workTime) * 80;
        }
        if (weeklyWage < 0) {
            weeklyWage = 0;
        }
        System.out.println("正式员工：" + employee.getName() + ",实际工资为：" + weeklyWage + "元。");
    }

    /**
     * @description 财务部门对兼职员工的访问
     * @author ym.y
     * @updateUser
     * @date 10:51 2020/12/18
     */
    @Override
    public void visit(PartTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("正式员工：" + employee.getName() + ",实际工资为：" + (workTime * hourWage) + "元。");
    }
}
