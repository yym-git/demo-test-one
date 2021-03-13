package com.person.cn.demotestone.event.statuschange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event.statuschange
 * @updateUser
 * @date 14:372020/11/1
 */
@Slf4j
@Component
public class FirstExecutor  implements EventExecutor{
    @Override
    public Set<String> supportTag() {
//        HashSet<String> setEvent = new HashSet<>();
//        setEvent.add(EventConstant.DELETE);
//        setEvent.add(EventConstant.UPDATE);
//        return setEvent;
        return new HashSet<String>(){
            {
                add(EventConstant.DELETE);
                add(EventConstant.UPDATE);
            }
        };
    }

    @Override
    public void handleEvent(StatusChangeEvent event) {
        log.info("first "+event.getContent());
    }
}
