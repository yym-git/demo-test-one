package com.person.cn.demotestone.lambda;

import java.util.Arrays;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 17:16 2020/12/9
 */
public class LambdaArray {
    public static void main(String[] args) {
        String[] arr1= new  String[]{"java","fkava","fkit","ios","android"};
        Arrays.parallelSort(arr1,(str1,str2)->str1.length()-str2.length());
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new  int[]{3,-4,25,16,30,18};
        Arrays.parallelPrefix(arr2,(left, right) ->left*right );
        System.out.println(Arrays.toString(arr2));
        long[] arr3 = new  long[5];
        Arrays.parallelSetAll(arr3,p->p*5);
        System.out.println(Arrays.toString(arr3));
    }
}
