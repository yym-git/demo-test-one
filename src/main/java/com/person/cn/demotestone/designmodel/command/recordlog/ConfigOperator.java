package com.person.cn.demotestone.designmodel.command.recordlog;

import java.io.Serializable;

/**
 * @author ym.y
 * @description 配置文件操作类：请求的接收者
 * @package com.person.cn.demotestone.designmodel.command.rrecordlog
 * @updateUser
 * @date 10:30 2020/12/16
 */
public class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("增加新的节点:" + args);
    }

    public void modify(String args) {
        System.out.println("修改节点:" + args);
    }

    public void delete(String args) {
        System.out.println("删除节点:" + args);
    }
}
