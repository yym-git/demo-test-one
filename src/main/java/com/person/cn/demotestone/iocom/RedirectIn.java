package com.person.cn.demotestone.iocom;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author ym.y
 * @description 重定向标准输入
 *  运行结果： 程序不会等待用户从键盘输入内容，而是直接将RedirectIn.java文件打印出来
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 17:572020/12/4
 */
public class RedirectIn {
    public static void main(String[] args) {
        String dir = "D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\iocom\\" +
                "RedirectIn.java";
        try (FileInputStream fis = new FileInputStream(dir)) {
            //将标准输入重定向到fis中
            System.setIn(fis);
            Scanner sc = new Scanner(System.in);
            //只把回车作为分隔符
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                System.out.println("键盘输入的内容是："+sc.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
