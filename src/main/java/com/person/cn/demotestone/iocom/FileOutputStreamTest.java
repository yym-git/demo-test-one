package com.person.cn.demotestone.iocom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ym.y
 * @description 文件字节输入流输出文件
 * 将文件保存到D盘下
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 14:532020/12/4
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        String dir = "D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\iocom\\FileOutputStreamTest.java";
        FileInputStream fos = null;
        FileOutputStream fps = null;
        try {
            fos = new FileInputStream(dir);
            fps = new FileOutputStream("D:\\newFile.txt");
            byte[] buf = new  byte[32];
            int hashRead  = 0;
            while((hashRead=fos.read(buf))>0){
                //将每次读取出的数据，写入到磁盘中
                fps.write(buf,0,hashRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fps.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
