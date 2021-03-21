package com.person.cn;

/**
 * @author ym.y
 * @description  构造函数的调用顺序
 * @package com.person.cn
 * @updateUser
 * @date 22:26 2021/3/16
 */
public class Child extends People {
    People farther;

    public Child(String name) {
        System.out.println(3);
        this.name = name;
        farther = new People(name+":F");
    }
    public Child() {
        System.out.println(4);
    }

    public static void main(String[] args) {

        new Child("mike");
    }
}
