package com.person.cn.demotestone.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.listener
 * @updateUser
 * @date 23:302020/10/27
 */
@Order(1)
public class FirstListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("第一个自定义监听器.......");
    }
}
