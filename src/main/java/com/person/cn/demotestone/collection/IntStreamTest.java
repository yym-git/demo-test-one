package com.person.cn.demotestone.collection;

import com.sun.deploy.security.BadCertificateDialog;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.stream.IntStream;

/**
 * @author ym.y
 * @description Java8 int流处理
 * @package com.person.cn.demotestone.collection
 * @updateUser
 * @date 13:02 2020/12/10
 */
public class IntStreamTest {
    public static void main(String[] args) {
        IntStream is  = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        System.out.println("最大的元素："+is.max().getAsInt());
        System.out.println("最小元素："+is.min().getAsInt());
        System.out.println("求和："+is.sum());
        System.out.println("is中所有元素的平均值："+is.average());
        System.out.println("所有平方大于20的元素的集合："+is.allMatch(ele->ele*ele> 29));
        System.out.println("映射后的新集合");
        IntStream newIs = is.map(ele->ele+2);
        newIs.forEach(System.out::println);
    }
}
