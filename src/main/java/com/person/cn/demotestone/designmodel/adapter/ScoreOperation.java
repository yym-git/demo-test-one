package com.person.cn.demotestone.designmodel.adapter;

/**
 * @author ym.y
 * @description 成绩排序接口
 * @package com.person.cn.demotestone.designmodel.adapter
 * @updateUser
 * @date 11:51 2020/12/13
 */
public interface ScoreOperation {
    public int[] sort(int[] array);

    public int search(int[] array, int key);
}
