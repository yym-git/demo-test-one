package com.person.cn.demotestone.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fx
 * @updateUser
 * @date 12:072020/12/1
 */
public class MyUtils {
    public static  <T>  T  copy(Collection<T> src,Collection<? super T > dest){
        T last  = null;
        for(T ele : src ){
            last = ele;
            dest.add(last);
        }
        return last;
    }

    public static void main(String[] args) {
        List<String> src = new ArrayList<String>();
        src.add("a");
        src.add("b");
        List<Object> tag  = new  ArrayList<Object>();
        String  t = copy(src,tag);
        System.out.println("最后一个元素："+t);
        System.out.println(tag);
    }
}
