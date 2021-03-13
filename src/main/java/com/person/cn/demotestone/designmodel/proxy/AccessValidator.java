package com.person.cn.demotestone.designmodel.proxy;

/**
 * @author ym.y
 * @description 身份验证类：业务类
 * @package com.person.cn.demotestone.designmodel.proxy
 * @updateUser
 * @date 12:38 2020/12/15
 */
public class AccessValidator {
    public boolean validate(String  userId){
        System.out.println("在数据库中验证用户‘"+userId+"’是不是合法用户？");
        if("yym".equals(userId)){
            System.out.println("‘"+userId+"’登录成功！");
            return  true;
        }else{
            System.out.println("‘"+userId+"’登录失败！");
            return false;
        }
    }
}
