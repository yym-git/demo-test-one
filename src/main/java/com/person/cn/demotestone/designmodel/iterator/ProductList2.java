package com.person.cn.demotestone.designmodel.iterator;

import java.util.List;

/**
 * @author ym.y
 * @description 商品数据类：具体聚合类
 * 将具体迭代器类作为具体聚合类的私有内部类
 * @package com.person.cn.demotestone.designmodel.iterator
 * @updateUser
 * @date 13:18 2020/12/16
 */
public class ProductList2 extends AbstractObjectList {
    public ProductList2(List products) {
        super(products);
    }
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator();
    }

    private class ProductIterator implements AbstractIterator {
        private List products;
        //定义一个游标，用于记录正向遍历的位置
        private int cursor1;
        //定义一个游标，用于记录逆向变量的位置
        private int cursor2;

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
         * @description 获取上一个元素
         * @author ym.y
         * @updateUser
         * @date 13:30 2020/12/16
         */
        @Override
        public Object getPreviousItem() {
            return products.get(cursor2);
        }
    }
}
