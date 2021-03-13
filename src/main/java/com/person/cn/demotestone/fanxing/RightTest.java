package com.person.cn.demotestone.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fanxing
 * @updateUser
 * @date 13:152020/12/1
 */
public class RightTest {
    public static  <T>  void test(Collection<? extends T> from, Collection<T> to){
        for(T o :  from){
            to.add(o);
        }
    }

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        List<Object> obj  = new ArrayList<>();
        test(str,obj);
    }
}
