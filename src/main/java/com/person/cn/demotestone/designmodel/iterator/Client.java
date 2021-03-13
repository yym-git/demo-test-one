package com.person.cn.demotestone.designmodel.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description
 * 如果需要新增加一个具体聚合类，只需要新增加一个聚合子类和一个新的具体迭代器类即可，
 * 原有类库代码无需改变，符合开闭原则。如果需要为ProductList聚合类更换一个迭代器，只需要增加一个新的具体迭代器
 * 类作为抽象迭代器类的子类，重新实现遍历方法即可。
 * @package com.person.cn.demotestone.designmodel.iterator
 * @updateUser
 * @date 13:33 2020/12/16
 */
public class Client {
    public static void main(String[] args) {
        List products  = new ArrayList();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("葵花宝典");
        products.add("九阳神功");
        products.add("九阴真经");

        AbstractObjectList list;
        AbstractIterator iterator;
        //创建聚合对象
        list = new ProductList(products);
        //由集合对象创建迭代器
        iterator = list.createIterator();
        System.out.println("正向遍历：");
        while(!iterator.isLast()){
            System.out.print(iterator.getNextItem()+",");
            iterator.next();
        }
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("逆向遍历：");
        while(!iterator.isFirst()){
            System.out.print(iterator.getPreviousItem()+",");
            iterator.previous();
        }
    }
}
