package com.person.cn.demotestone.annotation.testtable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ym.y
 * @description 针对TestTable注解的处理规则
 * @package com.person.cn.demotestone.annotation.testtable
 * @updateUser
 * @date 16:562020/12/3
 */
public class TestTableProcess {
    public static void process(String clazz) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        int passed = 0;
        int failed = 0;
        for(Method m  : Class.forName(clazz).getDeclaredMethods()){
            if(m.isAnnotationPresent(TestTable.class)){
                try{
                    //调用m方法
                    m.invoke(null);
                    passed++;

                }catch (Exception e){
                    System.out.println("方法"+ m+ "运行失败,异常:"+e.getCause()+"\n");
                    failed++;
                }
            }
        }
        //统计测试结果
        System.out.println("共运行了"+(passed+failed)+"个方法，其中:\n"+
                "失败："+failed+"个\n成功："+passed+"个");
    }
}
