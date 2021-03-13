package com.person.cn.demotestone.designmodel.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ym.y
 * @description 文件读取系统：子类系统
 * @package com.person.cn.demotestone.designmodel.facade
 * @updateUser
 * @date 10:33 2020/12/15
 */
public class FileReader {
    public String Reader(String fileNameSrc) {
        System.out.println("读取文件获取明文:");
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream inFs = new FileInputStream(fileNameSrc);
            int data;
            while ((data = inFs.read()) != -1) {
                sb = sb.append((char) data);
            }
            inFs.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件操作失败！");
        }
        return  sb.toString();
    }
}
