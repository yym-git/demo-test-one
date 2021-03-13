package com.person.cn.aop.com;

import org.springframework.stereotype.Component;

/**
 * @author ym.y
 * @description
 * @package com.atguigu.config
 * @updateUser
 * @date 10:03 2021/2/2
 */
@Component
public class User {
//    @Value("1")
    private Long id;
//    @Value("二哈")
    private String userName;
//    @Value("node_1")
    private String node;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", node='" + node + '\'' +
                '}';
    }
}
