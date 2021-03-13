package com.person.cn.demotestone.lambda;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 14:092020/12/9
 */
public class LambdaQs {
    public void eat(Eatable e) {
        System.out.println(e);
        e.taste();
    }

    public void drive(Flyable f) {
        System.out.println("正在驾驶：" + f);
        f.fly("晴空万里");
    }

    public void test(Addable add) {
        System.out.println("5+3="+add.add(5,3));
    }

    public static void main(String[] args) {
        LambdaQs qs = new LambdaQs();
        qs.eat(()-> System.out.println("苹果的味道不错"));
        qs.drive(weather ->{
            System.out.println("今天的天气："+weather);
            System.out.println("直升飞机飞行平稳");
        } );
        qs.test((a, b)-> a+b);
    }
}
