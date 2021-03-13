package com.person.cn.demotestone.designmodel.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.delegate
 * @updateUser
 * @date 12:16 2020/12/24
 */
public class Leader implements IEmployee {
    private Map<String, IEmployee> targets = new HashMap<>();

    public Leader() {
        targets.put("登录", new EmployeeA());
        targets.put("密码", new EmployeeB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
