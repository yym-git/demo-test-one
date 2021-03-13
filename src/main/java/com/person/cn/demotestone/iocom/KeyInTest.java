package com.person.cn.demotestone.iocom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author ym.y
 * @description 转换流的使用
 * 从键盘输入内容：字节输入流->转换->字符输入流
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 15:442020/12/4
 */
public class KeyInTest {
    public static void main(String[] args) {
        try (Reader isr = new InputStreamReader(System.in);
             //Reader流封装成BufferReader
            //具有缓冲功能：可以读取一行文本--以换行符为标志，如果没有读取到换行符，程序阻塞
             BufferedReader bufR = new BufferedReader(isr)) {
            String line = null;
            while((line = bufR.readLine())!= null){
                //如果读取的字符串为exit，则退出程序
                if(line.equals("exit")){
                    System.exit(1);
                }
                //打印读取的内容
                System.out.println("键盘输入的内容："+line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
