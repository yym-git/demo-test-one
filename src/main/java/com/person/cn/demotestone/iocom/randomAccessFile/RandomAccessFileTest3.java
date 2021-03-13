package com.person.cn.demotestone.iocom.randomAccessFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/**
 * @author ym.y
 * @description 文件内容中间插入新的内容
 * @package com.person.cn.demotestone.iocom.randomAccessFile
 * @updateUser
 * @date 13:572020/12/5
 */
public class RandomAccessFileTest3 {
    /**
     * @param fileName      文件名
     * @param index         插入的位置
     * @param insertContent 插入的内容
     * @description
     * @author ym.y
     * @updateUser
     * @date 13:59 2020/12/5
     */
    public static void insertFile(String fileName, long index, String insertContent) throws Exception {
        //临时文件的目录默认在系统用户目录下，不需要指定具体的目录
        File temp = File.createTempFile("temp", null);
        //系统退出时删除文件
        temp.deleteOnExit();
        RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
        FileInputStream tmpIn = new FileInputStream(temp);
        FileOutputStream tmpOut  = new FileOutputStream(temp);
        //将指针跳转到指定位置
        raf.seek(index);
        byte[] buff = new  byte[32];
        int hasRead = 0;
        while((hasRead = raf.read(buff))>0){
            //将从指定位置读取后的内容写入到临时文件中
            tmpOut.write(buff,0,hasRead);
        }
        //再次将文件指针移动到指定位置
        raf.seek(index);
        //追加新增得内容
        raf.write(insertContent.getBytes());
        //将临时文件的内容追加后面
        while((hasRead = tmpIn.read(buff))> 0){
            raf.write(buff,0,hasRead);
        }
    }

    public static void main(String[] args) throws Exception{
        insertFile("D:\\test.txt",4,"哈哈");
    }
}
