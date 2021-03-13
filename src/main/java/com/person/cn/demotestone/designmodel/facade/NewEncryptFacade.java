package com.person.cn.demotestone.designmodel.facade;

/**
 * @author ym.y
 * @description 新增加的外观类：具体外观类
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 11:09 2020/12/15
 */
public class NewEncryptFacade extends AbstractEncryptFacade {
    private FileReader reader;
    private FileWriter writer;
    private NewCipherMachine cipherMachine;

    public NewEncryptFacade() {
        this.reader = new FileReader();
        this.writer = new FileWriter();
        this.cipherMachine = new NewCipherMachine();
    }

    @Override
    public void fileEncrypt(String readFile, String writeFile) {
        String plainText = reader.Reader(readFile);
        String encryptText = cipherMachine.encrypt(plainText);
        writer.writer(encryptText, writeFile);
    }
}
