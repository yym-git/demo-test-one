package com.person.cn.demotestone.designmodel.builder;

import lombok.Data;

/**
 * @author ym.y
 * @description Actor角色类：复杂产品
 * @package com.person.cn.demotestone.designmodel.builder
 * @updateUser
 * @date 16:11 2020/12/12
 */
@Data
public class Actor {
    //角色类型
    private String type;
    //性别
    private String sex;
    //脸型
    private String face;
    //服装
    private String costume;
    //发型
    private String hairsStyle;
}
