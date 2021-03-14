package com.person.cn.controller;

import com.person.cn.aop.com.User;
import com.person.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.controller
 * @updateUser
 * @date 13:36 2021/3/14
 */
@RestController
@RequestMapping(value = "/test",produces = "application/json;charset=utf-8")
public class TestController {
    @Autowired
   private  UserService userService;
    @GetMapping("/aop")
    public void testAop(){
        User user = new User();
        user.setId(1L);
        user.setNode("二哈");
        user.setUserName("张三");
        System.out.println("方法执行前.......");
        userService.printUser(user);
        System.out.println("方法执结束.......");
    }
}
