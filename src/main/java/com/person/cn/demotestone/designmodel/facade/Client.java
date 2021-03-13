package com.person.cn.demotestone.designmodel.facade;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 10:56 2020/12/15
 */
public class Client {
    public static void main(String[] args) {
        EncryptFacade facade = new EncryptFacade();
        facade.fileEncrypt("D:\\test.txt","D:\\encrypt.txt");
    }
}
