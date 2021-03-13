package com.person.cn.demotestone.annotation.testtable;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation.testtable
 * @updateUser
 * @date 17:102020/12/3
 */
public class RunTestTable {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        TestTableProcess.process("com.person.cn.demotestone.annotation.testtable.MyTest");
    }
}
