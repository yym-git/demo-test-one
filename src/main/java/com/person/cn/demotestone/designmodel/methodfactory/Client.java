package com.person.cn.demotestone.designmodel.methodfactory;

/**
 * @author ym.y
 * @description 客户端
 * @package com.person.cn.demotestone.designmodel.methodfactory
 * @updateUser
 * @date 17:35 2020/12/11
 */
public class Client {
    public static void main(String[] args) {
        //获取具体的日志器工厂类
        LoggerFactory factory = new FileLoggerFactory();
        //由具体的日志器工厂类创建具体的日志器
        Logger logger = factory.createLogger();
        //调用具体日志器的方法
        logger.writeLog();
    }
}
