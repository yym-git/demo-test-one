package com.person.cn.demotestone.designmodel.bridge.example2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.bridge.example2
 * @updateUser
 * @date 21:02 2021/3/15
 */
public class Client {
    public static void main(String[] args) {
        Phone foldPhone = new FoldPhone(new XiaoMi());
        foldPhone.open();
        foldPhone.close();
        foldPhone.call();
        System.out.println("\n");
        Phone foldPhone1 = new FoldPhone(new Vivo());
        foldPhone1.open();
        foldPhone1.call();
        foldPhone1.call();
        System.out.println("*********************************");
        Phone foldPhone3 = new UpRightPhone(new XiaoMi());
        foldPhone3.open();
        foldPhone3.close();
        foldPhone3.call();
        System.out.println("\n");
        Phone foldPhone4 = new UpRightPhone(new Vivo());
        foldPhone4.open();
        foldPhone4.close();
        foldPhone4.call();
    }
}
