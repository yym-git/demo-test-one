package com.person.cn.demotestone.lambda;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 17:11 2020/12/9
 */
public class TestH {
    public static void main(String[] args) {
        Displayable displayable = new Displayable() {
            @Override
            public void display() {
                System.out.println(add(3,5));
            }
        };
        displayable.display();
    }
}
