package com.person.cn.demotestone.designmodel.simplyfactory;

/**
 * @author ym.y
 * @description 直方图
 * @package com.person.cn.demotestone.designmodel.simplyfactory
 * @updateUser
 * @date 16:29 2020/12/11
 */
public class HistogramChart implements  Chart {
    public HistogramChart(){
        System.out.println("创建柱形图");
    }
    @Override
    public void display() {
        System.out.println("显示柱形图");
    }
}
