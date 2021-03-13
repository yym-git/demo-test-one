package com.person.cn.demotestone.iocom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ym.y
 * @description  字节输入读取FileInputStreamTest文件的内容
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 14:312020/12/4
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        String dir ="D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\iocom\\FileInputStreamTest.java";
        //之所以创建输入流是因为程序运行是读取内存中的数据，而文件是保存在磁盘中的
        //所以程序在运行过程中需要将磁盘中的数据读取到内存中，然后在输出都控制台
        FileInputStream fis  = new FileInputStream(dir);
        byte[] buf = new byte[1024];
        int hasReader = 0;
        while((hasReader = fis.read(buf))>0){
            System.out.println(new String(buf,0,hasReader));
        }
        //文件IO流资源不属于内存资源，垃圾回收机制无法回收该资源，所以需要显示关闭资源
        fis.close();
    }
}
