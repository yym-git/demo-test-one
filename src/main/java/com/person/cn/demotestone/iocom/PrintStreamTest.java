package com.person.cn.demotestone.iocom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author ym.y
 * @description 处理流
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 15:122020/12/4
 */
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream fs = new FileOutputStream("D:\\test.txt");
        PrintStream ps  = new PrintStream(fs);
        ps.println("普通字符串");
        ps.println(new PrintStreamTest());
        //只需要关闭处理流，因为关闭处理流后，系统自动关闭被封装的节点流
        ps.close();
    }
}
