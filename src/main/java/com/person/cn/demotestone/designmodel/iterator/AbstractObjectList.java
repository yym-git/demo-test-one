package com.person.cn.demotestone.designmodel.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 抽象聚合类
 * @package com.person.cn.demotestone.designmodel.iterator
 * @updateUser
 * @date 13:08 2020/12/16
 */
public abstract class AbstractObjectList {
    protected List<Object> objects = new ArrayList<>();

    public AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void remove(Object obj) {
        this.objects.remove(obj);
    }

    public List getObject() {
        return this.objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();
}
