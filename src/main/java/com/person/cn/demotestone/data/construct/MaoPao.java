package com.person.cn.demotestone.data.construct;

import java.util.Arrays;

/**
 * @author ym.y
 * @description  冒泡排序算法
 * @package com.person.cn.demotestone.data.construct
 * @updateUser
 * @date 20:44 2021/1/12
 */
public class MaoPao {
    public static void main(String[] args) {
//        int[] arr = {1, 5, 2, 0, 4, -1};
        int[] arr = {5, 4, 2, 0, -1, 1};
        Arrays.asList(arr);
//        test(arr);
//        test2(arr);
        test3(arr);
    }


    /**
     * @description 分趟演示
     * @author ym.y
     * @updateUser
     * @date 21:41 2021/1/12
     */
    public static void test(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第一次");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二次");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第三次");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 4; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第四次");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 5; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第五次");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @description 一步到位
     * @author ym.y
     * @updateUser
     * @date 21:42 2021/1/12
     */
    public static void test2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("第" + (i + 1) + "趟：" + Arrays.toString(arr));
            }
        }
    }

    /**
     * @description 优化：已经排序好的不在执行排序代码
     * @author ym.y
     * @updateUser
     * @date 21:42 2021/1/12
     */
    public static void test3(int[] arr) {
        //是否交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟：" + Arrays.toString(arr));
            if (flag) {
                //发生过交换，重置
                flag = false;
            } else {
                //在一趟排序中一次交换都没有发生过,说明排序已经完成
                break;
            }
        }
    }
}
