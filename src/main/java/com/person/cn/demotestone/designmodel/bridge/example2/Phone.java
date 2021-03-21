package com.person.cn.demotestone.designmodel.bridge.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.bridge.example2
 * @updateUser
 * @date 20:53 2021/3/15
 */
public class Phone implements Brand {
    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }

    public void open() {
        this.brand.open();
    }

    public void close() {
        this.brand.close();
    }

    public void call() {
        this.brand.call();
    }


}
