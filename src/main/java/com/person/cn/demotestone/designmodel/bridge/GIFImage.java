package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description GIF格式图像：扩充抽象类
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:36 2020/12/13
 */
public class GIFImage extends Image {
    @Override
    public void parseFile(String fileName) {
        //模拟解析GIF文件并得到一个像素矩阵对象m
        Matrix m = new Matrix();
        imp.doPint(m);
        System.out.println(fileName+"，格式为GIF");
    }
}
