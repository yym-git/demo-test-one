package com.person.cn.demotestone.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.collection
 * @updateUser
 * @date 12:44 2020/12/10
 */
public class PredicateTest {
    public  static int callAll(Collection books, Predicate p){
        int total  = 0;
        for(Object obj  : books){
            if(p.test(obj)){
                total++;
            }
        }
        return  total;
    }

    public static void main(String[] args) {
        HashSet<String> books  = new HashSet<>();
        books.add("轻量级Java EE企业级实战");
        books.add("疯狂Java讲义");
        books.add("疯狂IOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");
        System.out.println( callAll(books,ele->((String)ele).contains("疯狂")));
        System.out.println(callAll(books, ele ->((String)ele).contains("Java")));
        System.out.println(callAll(books,ele->((String)ele).length()>10));
    }
}
