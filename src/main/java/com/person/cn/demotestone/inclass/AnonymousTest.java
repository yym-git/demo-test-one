package com.person.cn.demotestone.inclass;

/**
 * @author ym.y
 * @description Java8 以前局部内部类、匿名内部类访问的局部变量必须使用final修饰，Java8开始取消了这个限制，
 * 但是必须按照final修饰的规则使用,只能赋值一次
 * @package com.person.cn.demotestone.inclass
 * @updateUser
 * @date 13:302020/12/9
 */
public class AnonymousTest {
    public void  test(Product p){
        System.out.println("购买一个"+p.getName()+",花费"+p.getPrice()+"元");
    }
    public static void main(String[] args) {
        AnonymousTest  a = new AnonymousTest();
        int f = 9;
        a.test(new Product() {
            @Override
            public double getPrice() {
                int g  = f;
                return 23.5;
            }

            @Override
            public String getName() {
                return "AGP";
            }
        });
    }
}
