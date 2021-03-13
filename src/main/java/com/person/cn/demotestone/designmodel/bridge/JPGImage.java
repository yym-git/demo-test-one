package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description JPG格式图像：扩充抽象类
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:29 2020/12/13
 */
public class JPGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        //模拟解析JPG文件并获得一个像素矩阵对象m
        Matrix m = new Matrix();
        imp.doPint(m);
        System.out.println(fileName+",格式为JPG");
    }
}
