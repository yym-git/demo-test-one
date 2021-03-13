package com.person.cn.demotestone.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 22:482020/11/3
 */
public class TestHasMap {

    public static void main(String[] args) {

        int[] score = new int[]{2, 3, 7, 1, 9};
//        sum(score);
//        String a = "a";
//        String b = "b";
//        str(a, b);
//        System.out.println(a + "," + b);
//        test(score);

        maopao(score);
    }


    /**
     * @description 求数组中任意两个数的和等于10, 只遍历一次
     * @author ym.y
     * @updateUser
     * @date 17:10 2021/3/12
     */
    public static void sum(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        int target = 10;
        for (int i = 0; i < score.length; i++) {
            int num = target - score[i];
            if (map.containsKey(num)) {
                int index = map.get(num);
                System.out.println(score[i] + "," + score[index]);
            } else {
                map.put(score[i], i);
            }
        }
    }

    public static void str(String a, String b) {
        a = "123";
        b = "456";
    }


    /**
     * @description 求数组中去除最大值和最小值后的平均值，只遍历一次
     * @author ym.y
     * @updateUser
     * @date 17:10 2021/3/12
     */
    public static void test(int[] nums) {
        int[] arr = new int[4];
        arr[0] = nums[0];//max
        arr[1] = nums[0];//min
        arr[2] = 0;//sum
        for (int i = 0; i < nums.length; i++) {
            if (arr[0] < nums[i]) {
                arr[0] = nums[i];
            }
            if (arr[1] > nums[i]) {
                arr[1] = nums[i];
            }
            arr[2] += nums[i];
        }
        arr[2] = arr[2] - arr[0] - arr[1];
        arr[3] = arr[2] / (arr.length - 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    /**
     * @description  冒泡排序算法
     * @author ym.y
     * @updateUser
     * @date  17:35 2021/3/12
     */
    public static void maopao(int[] arr) {
        boolean  flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
