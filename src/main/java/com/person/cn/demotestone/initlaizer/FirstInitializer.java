package com.person.cn.demotestone.initlaizer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.initlaizer
 * @updateUser
 * @date 22:182020/10/22
 */
@Order(1)
public class FirstInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        //设置环境的必须属性（该属性没有设置值则启动报错）
//        environment.setRequiredProperties("yym");
        Map<String,Object>  map  = new HashMap<>();
        map.put("name","张三");
        MapPropertySource mapPropertySource  = new MapPropertySource("firstInitializer",map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("第一个初始化器被加载...........");
    }
}
