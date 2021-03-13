package com.person.cn.demotestone.designmodel.methodfactory;

/**
 * @author ym.y
 * @description 数据库日志记录器
 * @package com.person.cn.demotestone.designmodel.methodfactory
 * @updateUser
 * @date 17:29 2020/12/11
 */
public class DatabaseLogger implements  Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
