package com.person.cn.demotestone.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.collection
 * @updateUser
 * @date 11:37 2020/12/10
 */
public class IteratorTest {
    public static void main(String[] args) {
        HashSet<String> books = new HashSet<>();
        books.add("haah");
        books.add("dd");
        books.forEach(obj-> System.out.println("迭代集合元素："+obj));
        Iterator<String> it  = books.iterator();
        while(it.hasNext()){
            String  book = it.next();
            System.out.println("=="+book);
            if(book.equals("dd")){
                book = "ggg";
            }
        }
        books.forEach(obj-> System.out.println("==迭代集合元素："+obj));
    }
}
