package com.person.cn.demotestone.annotation;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation
 * @updateUser
 * @date 10:552020/12/4
 */
public class InheritableTest extends Base {
    public static void main(String[] args) {
        //结果 true
        System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }
}
