package com.person.cn.demotestone.lambda;

import lombok.experimental.var;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 16:52 2020/12/9
 */
public class LambdaAndInner {
    private  int age  = 12;
    private  static String name  ="疯狂软件教育";
    public void test(){
        String book= "疯狂Java讲义";
        Displayable dis =()->{
            System.out.println("book的局部变量："+book);
            //访问外部类的实例变量
            System.out.println("外部类的age实例变量："+age);
            System.out.println("外部类的name实例变量："+name);
//            System.out.println(add(3,5));
        };
        dis.display();
        System.out.println("求和："+dis.add(3,5));
    }
    public static void main(String[] args) {
        LambdaAndInner lambda = new  LambdaAndInner();
        lambda.test();
    }
}
