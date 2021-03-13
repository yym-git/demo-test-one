package com.person.cn.aop.com;

import org.springframework.stereotype.Service;

/**
 * @author ym.y
 * @description
 * @package com.atguigu.aop.com.aop2
 * @updateUser
 * @date 13:04 2021/2/2
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空！");
        }
        System.out.println("用户信息："+user);
    }
}
