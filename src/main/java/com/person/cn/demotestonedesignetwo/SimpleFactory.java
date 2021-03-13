package com.person.cn.demotestonedesignetwo;

/**
 * @author ym.y
 * @description 简单工厂
 * @package com.person.cn.demotestonedesignetwo
 * @updateUser
 * @date 19:51 2020/12/20
 */
public class SimpleFactory {


    public static Animal getAnimalRun(String type) {
        if ("dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("duck".equalsIgnoreCase(type)) {
            return new Duck();
        } else if ("bird".equalsIgnoreCase(type)) {
            return new Bird();
        } else {
            System.out.println("未知动物！");
            return null;
        }
    }
}
