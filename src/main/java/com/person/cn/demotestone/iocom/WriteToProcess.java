package com.person.cn.demotestone.iocom;

import org.apache.tomcat.jni.Proc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 11:542020/12/5
 */
public class WriteToProcess {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("java ReadStandard");
            PrintStream ps = new PrintStream(p.getOutputStream());
            ps.println("普通字符");
            ps.println(new WriteToProcess());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadStandard{
    public static void main(String[] args) {
        String dir ="D:\\out.txt";
        try(Scanner sc = new Scanner(System.in);
          PrintStream ps =  new PrintStream(new FileOutputStream(dir))
        ){
            sc.useDelimiter("\n");
           while(sc.hasNext()){
               ps.println("键盘输入的内容是："+sc.next());
           }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}