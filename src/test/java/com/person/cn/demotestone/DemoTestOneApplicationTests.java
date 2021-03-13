package com.person.cn.demotestone;

import com.person.cn.demotestone.bean.Teacher;
import com.person.cn.demotestone.event.statuschange.EventHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoTestOneApplicationTests {
    @Autowired
    private EventHandler eventHandler;
    @Autowired
    private Teacher teacher;
    @Test
    public  void  test(){
        System.out.println("teacher====name:"+teacher.getName());
    }

}
