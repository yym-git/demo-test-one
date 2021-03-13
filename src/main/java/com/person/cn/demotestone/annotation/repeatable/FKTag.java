package com.person.cn.demotestone.annotation.repeatable;

import java.lang.annotation.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation.repeatable
 * @updateUser
 * @date 12:302020/12/4
 */
@Repeatable(FKTags.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FKTag {
    String name() default "疯狂学";
    int age();
}
