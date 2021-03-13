package com.person.cn.demotestone.lambda;

import com.person.cn.demotestone.annotation.Inheritable;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 15:582020/12/9
 */
@FunctionalInterface
public interface Converter {
    Integer  convert(String from);
}
