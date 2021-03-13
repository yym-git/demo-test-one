package com.person.cn.demotestone.annotation.actionListenerFor;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @author ym.y
 * @description ActionListenerFor注解的处理规则
 * @package com.person.cn.demotestone.annotation.actionListenerFor
 * @updateUser
 * @date 17:352020/12/3
 */
public class ActionListenerForProcess {
    /**
     * @description   处理注释的方法
     * @author ym.y
     * @updateUser
     * @date  17:37 2020/12/3
     */
    public static void processAnnotation(Object obj){
        try{
            Class clazz = obj.getClass();
            for(Field f :  clazz.getDeclaredFields()){
                //将成员变量设置成可自由访问
                f.setAccessible(true);
//                boolean  flag = f.isAnnotationPresent(ActionListenerFor.class);
                //获取f属性上的ActionListenerFor类型的注解
                ActionListenerFor  a = f.getAnnotation(ActionListenerFor.class);
                //获取变量f的值
                Object fObj = f.get(obj);
                if(a != null && fObj != null ){
                    // 获取注解上的listener元数据
                    Class<? extends ActionListener>  listenerClass = a.listener();
//                    ActionListener al = listenerClass.getConstructor().newInstance();

                    ActionListener al = null;
                    if(listenerClass == ActionListenerForTest.OkListener.class){
                        al =  new ActionListenerForTest().new OkListener();
                    }else if(listenerClass == ActionListenerForTest.CancelListener.class){
                        al = new  ActionListenerForTest().new CancelListener();
                    }else{
                        System.out.println("类型不匹配");
                    }
                    AbstractButton ab  = (AbstractButton)fObj;
                    ab.addActionListener(al);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
