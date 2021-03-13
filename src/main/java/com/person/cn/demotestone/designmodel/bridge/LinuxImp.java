package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description Linux操作系统实现类：实现类接口
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:25 2020/12/13
 */
public class LinuxImp implements ImageImp {
    @Override
    public void doPint(Matrix m) {
        //调用Linux系统的绘制函数绘制像素矩阵
        System.out.println("在Linux操作系统中显示图像：");
    }
}
