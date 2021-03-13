package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

/**
 * @author ym.y
 * @description 具体UserDao：真实角色
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 13:26 2020/12/15
 */
public class UserDao implements  AbstractUserDao {

    @Override
    public boolean findUserById(String userId) {
       if("yym".equalsIgnoreCase(userId)){
           System.out.println("查询ID为‘"+userId+"’的用户信息成功！");
           return  true;
       }else{
           System.out.println("查询ID为‘"+userId+"’的用户信息失败！");
           return  false;
        }
    }
}
