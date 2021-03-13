package com.person.cn.demotestone.event.statuschange;

import org.omg.CORBA.CharSeqHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event.statuschange
 * @updateUser
 * @date 14:462020/11/1
 */
@Component
public class EventHandler implements ApplicationListener<ContextRefreshedEvent> {
   private  Map<String, Set<EventExecutor>> executorMap = new HashMap<>();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        synchronized (executorMap){
            ApplicationContext ac = event.getApplicationContext();
            Map<String,EventExecutor> map = ac.getBeansOfType(EventExecutor.class);
            if(map!= null && !map.isEmpty()){
                for(EventExecutor eventExecutor : map.values()){
                    for(String tag  : eventExecutor.supportTag()){
                        if(executorMap.containsKey(tag)){
                            executorMap.get(tag).add(eventExecutor);
                        }else{
                            Set<EventExecutor> set = new HashSet<>();
                            set.add(eventExecutor);
                            executorMap.put(tag,set);
                        }
                    }
                }
            }
        }
    }

    public void  handlerEvent(StatusChangeEvent event){
        executorMap.get(event.getTag()).forEach(it->it.handleEvent(event));
    }
}
