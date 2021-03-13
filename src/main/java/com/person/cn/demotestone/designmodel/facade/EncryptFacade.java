package com.person.cn.demotestone.designmodel.facade;

/**
 * @author ym.y
 * @description 加密外观类：外观类
 * 存在的问题：如果新增了子系统，则该类需要改动，同时Client也需要改动
 * 解决方法：引入抽象外观类
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 10:50 2020/12/15
 */
public class EncryptFacade {
    //维持对子系统的引用
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;
    public EncryptFacade() {
        this.reader = new FileReader();
        this.cipher = new CipherMachine();
        this.writer = new FileWriter();
    }
    /**
     * @description
     * @author ym.y
     * @updateUser
     * @param  fileNameSrc 读取的文件
     * @param  fileNameDes 保存密文的文件
     * @date  10:55 2020/12/15
     */
    public  void fileEncrypt(String fileNameSrc,String fileNameDes){
        String plaintStr = reader.Reader(fileNameSrc);
        String encryptStr = cipher.encrypt(plaintStr);
        writer.writer(encryptStr,fileNameDes);
    }
}
