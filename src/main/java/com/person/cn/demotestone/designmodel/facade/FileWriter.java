package com.person.cn.demotestone.designmodel.facade;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author ym.y
 * @description 文件保存系统：子类系统
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 10:46 2020/12/15
 */
public class FileWriter {
    /**
     * @description   保存密文
     * @author ym.y
     * @updateUser
     * @date  10:47 2020/12/15
     */
    public void writer(String  encryptStr,String fileNameDesc){
        System.out.println("保存密文，写入文件");
        try {
            FileOutputStream outFs = new FileOutputStream(fileNameDesc);
            outFs.write(encryptStr.getBytes());
            outFs.close();
        } catch (FileNotFoundException e){
            System.out.println("文件不存在！");
        }catch (Exception e) {
            System.out.println("文件操作有误！");
            e.printStackTrace();
        }
    }
}
