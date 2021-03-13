package com.person.cn.demotestone.uitls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.uitls
 * @updateUser
 * @date 23:132020/10/28
 */
@Component
public class JacksonSerialize implements SerializeInterface {
    @Override
    public String serialize(Object object) {
        try {
            System.out.println("jackSon 序列化.....");
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  "";
    }
}
