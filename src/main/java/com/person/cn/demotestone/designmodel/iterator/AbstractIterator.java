package com.person.cn.demotestone.designmodel.iterator;

/**
 * @author ym.y
 * @description 抽象迭代器
 * @package com.person.cn.demotestone.designmodel.iterator
 * @updateUser
 * @date 13:12 2020/12/16
 */
public interface AbstractIterator {
    //移至下一个元素
    public void next();

    //是否为最后一个元素
    public boolean isLast();

    //移至上一个元素
    public void previous();

    //是否为上一个元素
    public boolean isFirst();

    //获取下一个元素
    public Object getNextItem();

    //获取上一个元素
    public Object getPreviousItem();
}
