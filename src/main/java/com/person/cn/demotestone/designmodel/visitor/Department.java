package com.person.cn.demotestone.designmodel.visitor;

/**
 * @author ym.y
 * @description 部门类：抽象访问者
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 10:34 2020/12/18
 */
public abstract class Department {
    //此处访问元素没有使用抽象元素，
    // 是因为每个部门需要对兼职员工和全职员工做不同的处理
    public abstract void visit(FullTimeEmployee employee);
    public abstract void visit(PartTimeEmployee employee);
}
