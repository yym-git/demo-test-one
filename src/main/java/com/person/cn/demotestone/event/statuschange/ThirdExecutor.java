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
public class ThirdExecutor implements EventExecutor{
    @Override
    public Set<String> supportTag() {
        HashSet<String> setEvent = new HashSet<>();
        setEvent.add(EventConstant.UPDATE);
        setEvent.add(EventConstant.DELETE);
        return setEvent;
    }

    @Override
    public void handleEvent(StatusChangeEvent event) {
        log.info("third "+event.getContent());
    }
}
