package com.person.cn.demotestone.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.service
 * @updateUser
 * @date 22:232020/10/22
 */
@Component
public class TestService implements ApplicationContextAware {
    private  ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String  test(){
        return applicationContext.getEnvironment().getProperty("name3");
    }
}
