package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description Unix操作系统实现类：具体实现类
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:27 2020/12/13
 */
public class UnixImp implements ImageImp {
    @Override
    public void doPint(Matrix m) {
        //调用Unix系统的绘制函数绘制像素矩阵
        System.out.println("在Linux操作系统中显示图像：");
    }
}
