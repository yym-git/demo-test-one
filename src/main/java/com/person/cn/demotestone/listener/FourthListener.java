package com.person.cn.demotestone.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.listener
 * @updateUser
 * @date 23:412020/10/27
 */
public class FourthListener implements SmartApplicationListener {
    /**
     * 自定义要监听的事件
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationStartedEvent.class.isAssignableFrom(eventType) ||
                ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("第四个自定义监听器.......");
    }
}
