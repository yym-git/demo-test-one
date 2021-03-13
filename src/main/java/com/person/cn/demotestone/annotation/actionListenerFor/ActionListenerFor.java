package com.person.cn.demotestone.annotation.actionListenerFor;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation.actionListenerFor
 * @updateUser
 * @date 17:252020/12/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ActionListenerFor {
    //定义一个成员变量，用于设置原数据
    //该Listener成员变量用于保存监听器实现类
    //上限泛型类：该类只能是ActionListener类或者是其子类
    Class<? extends ActionListener> listener();
}
