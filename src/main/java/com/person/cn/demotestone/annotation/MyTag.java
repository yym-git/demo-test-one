package com.person.cn.demotestone.annotation;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation
 * @updateUser
 * @date 16:272020/12/3
 */
public @interface MyTag {
    String name() default "yym";
    int age() default 28;
}
