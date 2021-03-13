package com.person.cn.demotestone.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.fx
 * @updateUser
 * @date 11:232020/12/1
 */
public class TestOne {
    public static void main(String[] args) {
        List<String> strList  = new ArrayList<>();
        strList.add("hh");
//        test(strList);
        List<Object> listObj  = new ArrayList<>();
        listObj.addAll(strList);
        System.out.println(listObj);



    }
    public  static void  test(List<Object> c){
        for(int i =0; i< c.size(); i++){

        }
    }
}
