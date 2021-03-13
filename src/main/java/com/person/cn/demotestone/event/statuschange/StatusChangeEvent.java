package com.person.cn.demotestone.event.statuschange;

import lombok.Data;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 14:302020/11/1
 */
@Data
public class StatusChangeEvent {
    private  String  top;
    private  String tag;
    private  String  content;
}
