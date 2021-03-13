package com.person.cn.demotestone.event;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 23:222020/10/25
 */
public class WeatherEventMulticaster extends AbstractEventMulticaster {
    @Override
    void doStart() {
        System.out.println("广播器监听器开始监听.......");
    }

    @Override
    void doEnd() {
        System.out.println("广播器监听器结束监听.......");
    }
}
