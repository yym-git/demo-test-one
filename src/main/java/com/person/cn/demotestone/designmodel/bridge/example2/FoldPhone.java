package com.person.cn.demotestone.designmodel.bridge.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.bridge.example2
 * @updateUser
 * @date 20:57 2021/3/15
 */
public class FoldPhone extends Phone {
    public FoldPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("折叠式手机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("折叠式手机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("折叠式手机");
    }
}
