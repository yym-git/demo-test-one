package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author ym.y
 * @description 自定义请求处理程序类
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 13:32 2020/12/15
 */
public class DaoLogInvocationHandler implements InvocationHandler {
    private Calendar calendar;
    private Object obj;

    public DaoLogInvocationHandler() {
    }

    public DaoLogInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        //转发调用
        Object result = method.invoke(obj, args);
        afterInvoke();
        return result;
    }

    private void beforeInvoke() {
        calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String time = hour + ":" + minute + ":" + second;
        System.out.println("调用时间：" + time);
    }

    private void afterInvoke() {
        System.out.println("方法调用结束！");
    }
}

