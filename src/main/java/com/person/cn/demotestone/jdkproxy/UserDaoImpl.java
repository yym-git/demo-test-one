package com.person.cn.demotestone.jdkproxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.jdkproxy
 * @updateUser
 * @date 12:52 2021/1/27
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
