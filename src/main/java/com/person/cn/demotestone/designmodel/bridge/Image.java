package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description 抽象图像类
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:15 2020/12/13
 */
public abstract class Image {
    //引用抽象图像解析类
    protected ImageImp imp;

    public void setImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
