package com.person.cn.demotestone.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fanxing
 * @updateUser
 * @date 13:122020/12/1
 */
public class ErrorTest {
    public  static <T> void  test(Collection<T> from, Collection<T> to){
        for(T  o : from ){
            to.add(o);
        }
    }

    public static void main(String[] args) {
        List<Object> as = new ArrayList<>();
        List<String> ao = new ArrayList<>();
//        test(ao,as);

        List<Integer> li  = new  ArrayList<>();
        li.add(12);
        li.add(13);
        //泛型擦除
        List  list = li;
        List<String> ls =list;
        //下面代码运行异常
//        System.out.println("===="+ls.get(0));

        List<String>[] lsa = new ArrayList[10];
        Object[] oa  = lsa;
        List<Integer> lz = new ArrayList<>();
        lz.add(3);
        oa[1] = lz;
        //一下代码运行异常
//        String s  = lsa[1].get(0);
        test();

     }

     public static  void  test(){
        List<String>[] lsa  = new  ArrayList[10];
        Object[] oa  = lsa;
        List<Integer> li = new ArrayList<>();
        li.add(12);
        oa[1] = li;
        String target  = lsa[1].get(0);
         System.out.println(("返回结果==="+target));
     }
}
