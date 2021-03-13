package com.person.cn.demotestone.test;

import java.util.HashMap;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 17:57 2021/3/2
 */
public class SumTest {
    public static void main(String[] args) {
        int[]  array  =new int[]{2,7,11,15};
        int target = 9;
        HashMap<Integer,Integer> map = new  HashMap();
        for(int i=0; i<array.length; i++){
            int temp = target -array[i];
            if(map.containsKey(temp)){
                System.out.println(i+","+map.get(temp));
            }
            map.put(array[i],i);
        }
    }
}
