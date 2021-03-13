package com.person.cn.demotestone.designmodel.delegate;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.delegate
 * @updateUser
 * @date 12:20 2020/12/24
 */
public class Boss {
    public void command(String command, Leader leader) {
        leader.doing(command);
    }
}
