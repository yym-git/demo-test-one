package com.person.cn.demotestone.designmodel.methodfactory;

/**
 * @author ym.y
 * @description 文件日志记录器
 * @package com.person.cn.demotestone.designmodel.methodfactory
 * @updateUser
 * @date 17:30 2020/12/11
 */
public class FileLogger implements  Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
