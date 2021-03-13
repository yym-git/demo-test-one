package com.person.cn.demotestone.designmodel.proxy;

/**
 * @author ym.y
 * @description 日志记录类：业务类
 * @package com.person.cn.demotestone.designmodel.proxy
 * @updateUser
 * @date 12:43 2020/12/15
 */
public class Logger {
    public void log(String userId) {
        System.out.println("更新数据库，用户‘" + userId + "’查询次数加1");
    }
}
