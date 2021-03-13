package com.person.cn.demotestone.data.construct;

import java.util.Arrays;

/**
 * @author ym.y
 * @description 选择排序（从小到大）：第一次寻找出数组中最小的，第二次从剩下的数据中寻找最小的....依次循环
 * @package com.person.cn.demotestone.data.construct
 * @updateUser
 * @date 22:36 2021/1/12
 */
public class SelectorSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
//        test1(arr);
        test2(arr);
    }

    /**
     * @description 演示每一步的对比
     * @author ym.y
     * @updateUser
     * @date 22:55 2021/1/12
     */
    public static void test1(int[] arr) {
        int minIndex = 0;
        int min = arr[0];
        //循环结束找到本轮的最小值和最小值对应的下标
        for (int i = 0 + 1; i < arr.length; i++) {
            if (arr[i] < min) {
                minIndex = i;
                min = arr[i];
            }
        }
        //交换
        arr[minIndex] = arr[0];
        arr[0] = min;
        System.out.println("第一轮：" + Arrays.toString(arr));


        minIndex = 1;
        min = arr[1];
        //循环结束找到本轮的最小值和最小值对应的下标
        for (int i = 1 + 1; i < arr.length; i++) {
            if (arr[i] < min) {
                minIndex = i;
                min = arr[i];
            }
        }
        //交换
        arr[minIndex] = arr[1];
        arr[1] = min;
        System.out.println("第二轮：" + Arrays.toString(arr));

        minIndex = 2;
        min = arr[2];
        //循环结束找到本轮的最小值和最小值对应的下标
        for (int i = 2 + 1; i < arr.length; i++) {
            if (arr[i] < min) {
                minIndex = i;
                min = arr[i];
            }
        }
        //交换
        arr[minIndex] = arr[2];
        arr[2] = min;
        System.out.println("第三轮：" + Arrays.toString(arr));
    }

    /**
     * @description 一步到位 + 优化
     * @author ym.y
     * @updateUser
     * @date 23:09 2021/1/12
     */
    public static void test2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            //只有minIndex != j 时才交换（优化）
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }
    }
}
