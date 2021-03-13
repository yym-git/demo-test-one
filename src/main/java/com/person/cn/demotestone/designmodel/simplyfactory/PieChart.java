package com.person.cn.demotestone.designmodel.simplyfactory;

/**
 * @author ym.y
 * @description 饼状图
 * @package com.person.cn.demotestone.designmodel.simplyfactory
 * @updateUser
 * @date 16:31 2020/12/11
 */
public class PieChart implements  Chart {
    public PieChart(){
        System.out.println("创建饼状图");
    }
    @Override
    public void display() {
        System.out.println("显示饼状图");
    }
}
