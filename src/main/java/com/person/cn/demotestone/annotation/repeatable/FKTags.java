package com.person.cn.demotestone.annotation.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ym.y
 * @description 自定义重复使用注解
 * @package com.person.cn.demotestone.annotation.repeatable
 * @updateUser
 * @date 12:322020/12/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FKTags {
    //定义value成员变量，该变量可接受多个@FKTag注解
    FKTag[] value();
}
