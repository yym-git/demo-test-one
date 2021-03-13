package com.person.cn.demotestone.designmodel.visitor;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 11:12 2020/12/18
 */
public class Client {
    public static void main(String[] args) {
        test1();
        System.out.println("-----------------------------");
        test2();
    }

    public static void test1() {
        EmployeeList list = new EmployeeList();
        Employee fte1, fte2, fte3, pte1, pte2;
        fte1 = new FullTimeEmployee("张无忌", 3200.00, 50);
        fte2 = new FullTimeEmployee("杨过", 2000.00, 40);
        fte3 = new FullTimeEmployee("段誉", 2400.00, 36);
        pte1 = new PartTimeEmployee("洪七公", 80.00, 20);
        pte2 = new PartTimeEmployee("郭靖", 60.00, 18);
        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);
        Department dep = new HRDepartment();
        list.accept(dep);
    }

    public static void test2() {
        EmployeeList list = new EmployeeList();
        Employee fte1, fte2, fte3, pte1, pte2;
        fte1 = new FullTimeEmployee("张无忌", 3200.00, 50);
        fte2 = new FullTimeEmployee("杨过", 2000.00, 40);
        fte3 = new FullTimeEmployee("段誉", 2400.00, 36);
        pte1 = new PartTimeEmployee("洪七公", 80.00, 20);
        pte2 = new PartTimeEmployee("郭靖", 60.00, 18);
        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);
        Department dep = new FADepartment();
        list.accept(dep);
    }
}
