package com.person.cn.demotestone.uitls;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.uitls
 * @updateUser
 * @date 23:112020/10/28
 */
@Component
public class FastJsonSerialize implements  SerializeInterface {
    @Override
    public String serialize(Object object) {
        System.out.println("fastJson序列化.....");
        return JSON.toJSONString(object);
    }
}
