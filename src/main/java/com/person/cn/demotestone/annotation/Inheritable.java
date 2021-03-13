package com.person.cn.demotestone.annotation;

import java.lang.annotation.*;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone
 * @updateUser
 * @date 10:532020/12/4
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Inheritable {
}
