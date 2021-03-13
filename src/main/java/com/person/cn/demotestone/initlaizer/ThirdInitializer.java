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
@Order(3)
public class ThirdInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        Map<String,Object>  map  = new HashMap<>();
        map.put("name3","王五");
        MapPropertySource mapPropertySource  = new MapPropertySource("ThirdInitializer",map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("第三个初始化器被加载...........");
    }
}
