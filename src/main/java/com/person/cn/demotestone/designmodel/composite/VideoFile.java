package com.person.cn.demotestone.designmodel.composite;

/**
 * @author ym.y
 * @description 视频文件类：叶子构件
 * @package com.person.cn.demotestone.designmodel.composite
 * @updateUser
 * @date 16:08 2020/12/13
 */
public class VideoFile extends AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");

    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("-----对视频文件'" + name + "'进行杀毒！");
    }
}
