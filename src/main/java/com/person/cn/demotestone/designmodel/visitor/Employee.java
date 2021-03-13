package com.person.cn.demotestone.designmodel.visitor;

/**
 * @author ym.y
 * @description 全体员工类：抽象元素
 * @package com.person.cn.demotestone.designmodel.visitor
 * @updateUser
 * @date 10:33 2020/12/18
 */
interface Employee {
    //抽象元素接受一个抽象访问者的访问
    public void accept(Department handler);
}
