package com.person.cn.demotestone.designmodel.facade;

/**
 * @author ym.y
 * @description 基于移位运算的数据加密：子类系统
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 11:11 2020/12/15
 */
public class NewCipherMachine {
    public String encrypt(String plainText) {
        System.out.println("数据加密，将明文加密成密文。");
        String es = "";
        //设置密钥，移位数位
        int key = 10;
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            //小写字母移位
            if (c >= 'a' && c <= 'z') {
                c += key % 26;
                if (c > 'z') c -= -26;
                if (c < 'a') c += 26;
            }
            //大字母移位
            if (c >= 'A' && c <= 'Z') {
                c += key % 26;
                if (c > 'Z') c -= 26;
                if (c < 'A') c += 26;
            }
            es = es + c;
        }
        return es;
    }
}
