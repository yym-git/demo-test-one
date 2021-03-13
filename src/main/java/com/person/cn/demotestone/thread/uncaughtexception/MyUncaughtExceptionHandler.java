package com.person.cn.demotestone.thread.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ym.y
 * @description  自定义未捕获异常处理器
 * @package com.person.cn.demotestone.thread.uncaughtexception
 * @updateUser
 * @date 21:11 2020/12/27
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，终止线程："+t.getName(),e);
    }
}
