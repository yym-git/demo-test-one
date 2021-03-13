package com.person.cn.demotestone.designmodel.methodfactory;

/**
 * @author ym.y
 * @description 数据库日志记录器
 * @package com.person.cn.demotestone.designmodel.methodfactory
 * @updateUser
 * @date 17:33 2020/12/11
 */
public class DatabaseLoggerFactory implements  LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
