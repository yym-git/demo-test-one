package com.person.cn;

/**
 * @author ym.y
 * @description
 * @package com.person.cn
 * @updateUser
 * @date 22:24 2021/3/16
 */
public class People {
    String name;

    public People() {
        System.out.println(1);

    }
    public People(String name) {
        System.out.println(2);
        this.name = name;
    }
}
