package com.person.cn.demotestone.designmodel.visitor;

/**
 * @author ym.y
 * @description 人力资源部类：具体访问者
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 10:52 2020/12/18
 */
public class HRDepartment extends Department {
    /**
     * @description 人力资源部门对全职员工的访问
     * @author ym.y
     * @updateUser
     * @date 10:52 2020/12/18
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        if (workTime > 40) {
            System.out.println("正式员工" + employee.getName() + ",实际工作时间为："
                    + workTime + "小时,加班时间为：" + (workTime - 40) + "小时。");
        } else {
            System.out.println("正式员工" + employee.getName() + ",实际工作时间为："
                    + workTime + "小时,请假时间：" + (40 - workTime) + "小时。");
        }
    }

    /**
     * @description 人力资源部门对兼职员工的访问
     * @author ym.y
     * @updateUser
     * @date 10:53 2020/12/18
     */
    @Override
    public void visit(PartTimeEmployee employee) {
        System.out.println("兼职员工" + employee.getName() + ",实际工作时间为：" + employee.getWorkTime() + "小时");
    }
}
