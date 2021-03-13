package com.person.cn.demotestone.uitls;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.uitls
 * @updateUser
 * @date 23:262020/10/28
 */
@Component
public class MoocSpringContainer implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext ac;
    private  static MoocSpringContainer moocSpringContainer;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (ac == null){
            ac = event.getApplicationContext();
        }
        moocSpringContainer = this;
    }
    public static MoocSpringContainer getInstance(){
        return  moocSpringContainer;
    }

    public  <T> T  getBean(Class<T> clazz){
        return  ac.getBean(clazz);
    }
}
