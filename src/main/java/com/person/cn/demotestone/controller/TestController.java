package com.person.cn.demotestone.controller;

import com.person.cn.demotestone.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.controller
 * @updateUser
 * @date 22:162020/10/22
 */

@Controller
@RequestMapping("/demo")
public class TestController {
    @Autowired
    private TestService service;
    @RequestMapping("/test")
    @ResponseBody
    public  String  test(){
        return service.test();
    }
}
