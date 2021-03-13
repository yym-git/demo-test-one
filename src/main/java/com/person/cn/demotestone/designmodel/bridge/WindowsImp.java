package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description Windows操作系统实现类：实现类接口
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:23 2020/12/13
 */
public class WindowsImp implements  ImageImp {
    @Override
    public void doPint(Matrix m) {
        //调用windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows系统中显示图像：");
    }
}
