package com.person.cn.demotestone.fanxing;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fx
 * @updateUser
 * @date 12:462020/12/1
 */
public class GenericMethodTest {
    /**
     * 将数组元素复制到集合中
     *
     * @param src
     * @param tag
     */
    public static <T> void fromArrayToCollection(T[] src, Collection<T> tag) {
        for (T o : src) {
            tag.add(o);
        }
    }

    public static void main(String[] args) {
        Object[] obj = new Object[100];
        Collection<Object> co = new ArrayList<>();
        //T 代表Object
        fromArrayToCollection(obj, co);
        String[] str = new String[100];
        Collection<String> cs = new ArrayList<>();
        //T代表String
        fromArrayToCollection(str, cs);
        //T代表Object
        fromArrayToCollection(str, co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn  = new ArrayList<>();
        //T 代表Number
        fromArrayToCollection(ia,cn);
        //T 代表Number
        fromArrayToCollection(fa,cn);
        //T 代表Number
        fromArrayToCollection(na,cn);
        //T 代表Object
        fromArrayToCollection(na,co);
        //下面代码中T代表String类型，但na是一个Number数组
        //因为Number既不是String类型，也不是String的子类，所以编译出现错误
//        fromArrayToCollection(na,str);
    }
}
