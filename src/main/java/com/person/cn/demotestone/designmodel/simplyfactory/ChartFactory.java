package com.person.cn.demotestone.designmodel.simplyfactory;

/**
 * @author ym.y
 * @description 图表工厂类
 * @package com.person.cn.demotestone.designmodel.simplyfactory
 * @updateUser
 * @date 16:34 2020/12/11
 */
public class ChartFactory {
    public static  Chart getChart(String type){
        Chart  chart = null;
        if(type.equalsIgnoreCase("histogram")){
            chart = new HistogramChart();
            System.out.println("初始化柱形图");
        }else if(type.equalsIgnoreCase("pie")){
            chart = new PieChart();
            System.out.println("初始化饼状图");
        }else if(type.equalsIgnoreCase("line")){
            chart = new LineChart();
            System.out.println("初始化折线图");
        }
        return  chart;
    }
}
