package com.person.cn.demotestone.designmodel.simplyfactory;

/**
 * @author ym.y
 * @description 折线图
 * @package com.person.cn.demotestone.designmodel.simplyfactory
 * @updateUser
 * @date 16:32 2020/12/11
 */
public class LineChart implements  Chart {
    public LineChart(){
        System.out.println("创建折线图");
    }
    @Override
    public void display() {
        System.out.println("显示折线图");
    }
}
