package com.person.cn.demotestone.annotation.testtable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ym.y
 * @description 自定义的TestTable注解
 * @package com.person.cn.demotestone.annotation
 * @updateUser
 * @date 16:412020/12/3
 */
//指定TestTable可以保留多久
@Retention(RetentionPolicy.RUNTIME)
//指定TestTable的作用目标
@Target(ElementType.METHOD)
public @interface TestTable {
}
