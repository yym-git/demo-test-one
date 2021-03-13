package com.person.cn.demotestone.designmodel.adapter;

/**
 * @author ym.y
 * @description二分查找:针对于有序集合,适配者
 * @package com.person.cn.demotestone.designmodel.adapter
 * @updateUser
 * @date 12:27 2020/12/13
 */
public class BinarySearch {
    public int binarySearch(int[] array, int key) {
        int low = 0;
        //数组的最后一个元素
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                //找到元素返回1
                return 1;
            }
        }
        //未找到元素返回-1
        return -1;
    }
}
