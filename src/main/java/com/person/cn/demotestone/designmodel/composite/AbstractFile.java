package com.person.cn.demotestone.designmodel.composite;

/**
 * @author ym.y
 * @description 抽象文件类：抽象构件（容器类）
 * @package com.person.cn.demotestone.designmodel.composite
 * @updateUser
 * @date 15:56 2020/12/13
 */
public abstract class AbstractFile {

    public abstract void killVirus();

    //可以将以下三个方法移到具体的子类中去实现（这种属于安全模式组合）
    //放在该抽象类中，透明组合模式
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);
}
