package com.person.cn.demotestone.designmodel.iterator;

import java.util.List;

/**
 * @author ym.y
 * @description 商品迭代器：具体迭代器
 * @package com.person.cn.demotestone.designmodel.iterator
 * @updateUser
 * @date 13:17 2020/12/16
 */
public class ProductIterator implements AbstractIterator {
    //具体迭代器类关联具体聚合器类
    //目的：访问存储在聚合对象中的数据，以便迭代器能够对这些数据进行遍历操作
    private ProductList productList;
    private List products;
    //定义一个游标，用于记录正向遍历的位置
    private int cursor1;
    //定义一个游标，用于记录逆向变量的位置
    private int cursor2;
    /**
     * @description 具体迭代器类中引用具体聚合类
     * @author ym.y
     * @updateUser
     * @date  13:55 2020/12/16
     */
    public ProductIterator(ProductList list) {
        this.productList = list;
        this.products = list.getObject();
        cursor1 = 0;
        cursor2 = products.size() - 1;
    }

    @Override
    public void next() {
        if (cursor1 < products.size()) {
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return (cursor1 == products.size());
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return (cursor2 == -1);
    }

    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    /**
     * @description   获取上一个元素
     * @author ym.y
     * @updateUser
     * @date  13:30 2020/12/16
     */
    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
