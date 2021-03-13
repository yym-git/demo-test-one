package com.person.cn.demotestone.designmodel.bridge;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.bridge
 * @updateUser
 * @date 14:41 2020/12/13
 */
public class Client {
    public static void main(String[] args) {
        ImageImp imageImp = new WindowsImp();
        Image image = new JPGImage();
        image.setImp(imageImp);
        image.parseFile("小龙女");
    }
}
