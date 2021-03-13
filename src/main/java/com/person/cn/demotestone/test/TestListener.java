package com.person.cn.demotestone.test;

import com.person.cn.demotestone.bean.NewResultModel;
import com.person.cn.demotestone.bean.OldResult;
import com.person.cn.demotestone.bean.OldResultModel;
import com.person.cn.demotestone.event.statuschange.EventConstant;
import com.person.cn.demotestone.event.statuschange.EventHandler;
import com.person.cn.demotestone.event.statuschange.StatusChangeEvent;
import com.person.cn.demotestone.uitls.MoocUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 23:472020/10/28
 */

public class TestListener {
    @Autowired
    private EventHandler eventHandler;
    @Test
    public void test2(){
        StatusChangeEvent event = new StatusChangeEvent();
        event.setTop("default");
        event.setTag(EventConstant.INSERT);
        event.setContent("hhh");
        eventHandler.handlerEvent(event);
    }
}
