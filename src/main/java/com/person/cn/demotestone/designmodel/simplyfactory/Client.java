package com.person.cn.demotestone.designmodel.simplyfactory;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.simplyfactory
 * @updateUser
 * @date 16:38 2020/12/11
 */
public class Client {
    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart("histogram");
        chart.display();
    }
}
