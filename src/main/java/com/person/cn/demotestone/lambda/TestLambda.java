package com.person.cn.demotestone.lambda;

import javax.swing.*;
import java.math.BigDecimal;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 15:592020/12/9
 */
public class TestLambda {
    public static void main(String[] args) {

        Converter converter = from -> Integer.valueOf(from);
        Integer val = converter.convert("99");
        System.out.println(val);
        //使用类方法引用替换
        Converter converter1 = Integer::valueOf;
        Integer va2 = converter1.convert("99");
        System.out.println(va2);

        //引用特定对象的实例方法
        Converter converter2 = from -> "fkit.org".indexOf(from);
        Converter converter2_1 = "fkit.org"::indexOf;
        Integer index = converter2.convert("it");

        //引用某类对象的实例
        MyTest mt = (a, b, c) -> a.substring(b, c);
        String str = mt.test("Java I Love you", 2, 9);
        System.out.println(str);
        MyTest mt2 = String::substring;
        String str2 = mt.test("Java I Love you", 2, 9);

        //引用构造器
        YourTest yt = title -> new JFrame(title);
        JFrame jf = yt.win("我的窗口");

        YourTest yt2 = JFrame::new;
        JFrame jf2 = yt2.win("我的窗口");

        //计算两个数的四则运算
        BigDecimal b1 = new BigDecimal("12");
        BigDecimal b2 = new BigDecimal("12");

        CalculateDouble add =(a,b)->a+b;
        CalculateDouble sub =(a,b)->a-b;
        CalculateDouble mu = (a,b)->a*b;
        CalculateDouble dv = (a,b)->a/b;


    }
}
