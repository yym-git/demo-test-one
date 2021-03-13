package com.person.cn.demotestone.event.statuschange;

import java.util.Set;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 14:342020/11/1
 */
public interface EventExecutor {

    Set<String> supportTag();

    void  handleEvent(StatusChangeEvent event);
}
