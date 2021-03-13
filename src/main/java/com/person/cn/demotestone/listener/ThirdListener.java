package com.person.cn.demotestone.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.listener
 * @updateUser
 * @date 23:382020/10/27
 */
public class ThirdListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("第三个自定义监听器..........");
    }
}
