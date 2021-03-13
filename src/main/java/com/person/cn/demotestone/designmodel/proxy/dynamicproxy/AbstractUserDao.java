package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

/**
 * @author ym.y
 * @description 抽象UserDao：抽象主题角色
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 13:23 2020/12/15
 */
public interface AbstractUserDao {
    public boolean findUserById(String userId);
}
