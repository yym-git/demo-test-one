package com.person.cn.demotestone.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.reflect
 * @updateUser
 * @date 15:512020/12/3
 */
public class GenericType {
    private Map<String, Integer> score;

    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = GenericType.class;
        Field f = clazz.getDeclaredField("score");
        System.out.println("score的类型是：" + f.getType());
        //获取泛型类型
        Type type = f.getGenericType();
        if(type  instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType) type;
            //获取原类型
            Type  rType =  pType.getRawType();
            System.out.println("原始类型："+rType);
            //获取泛型类型的泛型参数
            Type[] tArgs  = pType.getActualTypeArguments();
            for(int i  =0 ;  i< tArgs.length; i++){
                System.out.println("第"+ (i+1)+ "个泛型类型是:"+tArgs[i]);
            }
        }else{
            System.out.println("泛型类型出错");
        }

    }
}
