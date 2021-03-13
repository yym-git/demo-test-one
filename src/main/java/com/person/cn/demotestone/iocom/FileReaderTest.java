package com.person.cn.demotestone.iocom;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author ym.y
 * @description 字符输入流读取FIleReader文件的内容，并打印到控制台
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 14:432020/12/4
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        String dir = "D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\iocom\\FileReaderTest.java";
        FileReader fr = new FileReader(dir);
        //每次读取的字符长度
        char[] ch  = new  char[128];
        //实际读取的字符长度
        int hasRead = 0;
        while((hasRead = fr.read(ch))>0){
            System.out.println(new String(ch,0,hasRead));
        }
        fr.close();
    }
}
