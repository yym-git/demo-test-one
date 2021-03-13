package com.person.cn.demotestone.designmodel.facade;

/**
 * @author ym.y
 * @description 数据加密类：子系统
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 10:42 2020/12/15
 */
public class CipherMachine {
    public String encrypt(String plainText) {
        System.out.println("数据加密，将明文转换为密文:");
        String es = "";
        for (int i = 0; i < plainText.length(); i++) {
            String c = String.valueOf(plainText.charAt(i) % 7);
            es = es + c;
        }
        System.out.println("加密后的密文：" + es);
        return es;
    }
}
