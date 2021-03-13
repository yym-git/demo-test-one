package com.person.cn.demotestone.iocom;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author ym.y
 * @description 重定向标准输出：以下程序会在D盘下生成一个redirect.txt文件,而不是在控制台打印内容
 * 将System.out.println()的控制台输出，重定向为向文件写内容
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 17:452020/12/4
 */
public class RedirectOut {
    public static void main(String[] args) {
        try(PrintStream ps  = new PrintStream(new FileOutputStream("D:\\redirect.txt"))){
            //将标准输出重定向到ps输出流
            System.setOut(ps);
            //向标准输出输出一个字符串
            System.out.println("普通字符串");
            //向标准输出输出一个对象
            System.out.println(new RedirectOut());
        }catch (Exception e){}
    }
}
