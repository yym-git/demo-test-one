package com.person.cn.demotestone.designmodel.iterator;

import java.util.List;

/**
 * @author ym.y
 * @description 商品数据类：具体聚合类
 * @package com.person.cn.demotestone.designmodel.iterator
 * @updateUser
 * @date 13:18 2020/12/16
 */
public class ProductList extends AbstractObjectList {
    public ProductList(List products) {
        super(products);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
