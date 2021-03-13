package com.person.cn.demotestone.designmodel.methodfactory;

/**
 * @author ym.y
 * @description 文件日志记录器
 * @package com.person.cn.demotestone.designmodel.methodfactory
 * @updateUser
 * @date 17:34 2020/12/11
 */
public class FileLoggerFactory implements  LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
