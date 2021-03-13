package com.person.cn.demotestone.designmodel.composite;

import java.util.ArrayList;

/**
 * @author ym.y
 * @description 文件类：容器构件
 * @package com.person.cn.demotestone.designmodel.composite
 * @updateUser
 * @date 16:11 2020/12/13
 */
public class Folder extends AbstractFile {
    //定义集合fileList，用于存储AbstractFile类型的成员
    private ArrayList<AbstractFile> fileList = new ArrayList<>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("***********对文件夹'" + name + "'进行杀毒");
        for (AbstractFile obj : fileList) {
            obj.killVirus();
        }
    }
}
