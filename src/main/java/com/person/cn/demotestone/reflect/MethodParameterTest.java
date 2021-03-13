package com.person.cn.demotestone.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 13:272020/12/2
 */
public class MethodParameterTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Test> clazz = Test.class;
        Method replace = clazz.getMethod("replace", String.class, List.class);
        System.out.println("replace方法的参数个数："+replace.getParameterCount());
        //获取所有的参数信息
        Parameter[] parameters = replace.getParameters();
        int index = 1;
        for(Parameter p  : parameters ){
            if(p.isNamePresent()){
                System.out.println("---第"+index++ +"个参数信息");
                System.out.println("参数名："+p.getName());
                System.out.println("形参类型："+p.getType());
                System.out.println("泛型类型："+p.getParameterizedType());
            }
        }
    }
    class Test{
        public void  replace(String str, List<String> list){

        }
    }
}
