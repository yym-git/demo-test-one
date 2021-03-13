package com.person.cn.demotestonedesignetwo;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestonedesignetwo
 * @updateUser
 * @date 19:56 2020/12/20
 */
public class Client {
    public static void main(String[] args) {
        Animal  animal = SimpleFactory.getAnimalRun("dog");
        animal.run();
        Animal  animal2 = SimpleFactory.getAnimalRun("duck");
        animal2.run();
        Animal  animal3 = SimpleFactory.getAnimalRun("duck1");
        animal3.run();
    }
}
