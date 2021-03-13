package com.person.cn.demotestone.thread.copyonwrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.copyonwrite
 * @updateUser
 * @date 11:54 2021/1/2
 */
public class CopyOnWriteArrayListOne {
    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.get(2);
        Iterator<String> iterable = list.iterator();
        while(iterable.hasNext()){
            System.out.println("List is it:"+list);
            String next = iterable.next();
            System.out.println(next);
            if(next.equals("2")){
                list.remove("5");
            }
            if(next.equals("3")){
                list.add("五");
            }
        }
    }
}
