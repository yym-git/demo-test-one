package com.person.cn.demotestone.designmodel.adapter;

/**
 * @author ym.y
 * @description 对象适配器
 * @package com.person.cn.demotestone.designmodel.adapter
 * @updateUser
 * @date 12:38 2020/12/13
 */
public class OperationAdapter implements ScoreOperation {
    //定义适配者QuickSort对象
    private QuickSort sort;
    //定义适配者BinarySearch对象
    private BinarySearch search;

    public OperationAdapter() {
        sort = new QuickSort();
        this.search = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        //调用适配者类QuickSort的排序方法
        return sort.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        //调用适配者类BinarySearch的查找方法
        return search.binarySearch(array, key);
    }
}
