package com.person.cn.demotestone.designmodel.methodfactory;

/**
 * @author ym.y
 * @description 日志记录器工厂
 * @package com.person.cn.demotestone.designmodel.methodfactory
 * @updateUser
 * @date 17:31 2020/12/11
 */
public interface LoggerFactory {
    /**
     * @description 创建日志记录器方法
     * @author ym.y
     * @updateUser
     * @date  17:32 2020/12/11
     */
    public Logger createLogger();
}
