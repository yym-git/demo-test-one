package com.person.cn.demotestone;

import com.person.cn.demotestone.service.ServiceA;
import com.person.cn.demotestone.service.ServiceB;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoTestOneApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoTestOneApplication.class, args);
//        SpringApplication springApplication = new SpringApplication(DemoTestOneApplication.class);
//        springApplication.addInitializers(new SecondInitializer());
//        springApplication.run(args);
//        springApplication.addListeners(new SecondListener());
//        springApplication.run(args);
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceA serviceA =classPathXmlApplicationContext.getBean("a", ServiceA.class);
        ServiceB  serviceB = classPathXmlApplicationContext.getBean("b", ServiceB.class);
    }

}
