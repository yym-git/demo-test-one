package com.person.cn.demotestone.jdkproxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.jdkproxy
 * @updateUser
 * @date 13:03 2021/1/27
 */
public class JdkTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserDao userDao = (UserDao)jdkProxy.createProxy(new UserDaoImpl());
        userDao.addUser();
        userDao.deleteUser();
    }
}
