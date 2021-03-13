package com.person.cn.demotestone.designmodel.command.recordlog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 文件操作类
 * @package com.person.cn.demotestone.designmodel.command.recordlog
 * @updateUser
 * @date 10:59 2020/12/16
 */
public class FileUtil {
    /**
     * @description 将命令集合写入日志文件中
     * @author ym.y
     * @updateUser
     * @date 11:00 2020/12/16
     */
    public static void writeCommand(List commands) {
        try {
            FileOutputStream file = new FileOutputStream("D:\\config\\config.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(file));
            //进行序列化
            objOut.writeObject(commands);
            objOut.close();
        } catch (Exception e) {
            System.out.println("命令保存失败！");
            e.printStackTrace();
        }
    }


    /**
     * @description 从日志文件中提取命令集合
     * @author ym.y
     * @updateUser
     * @date 11:04 2020/12/16
     */
    public static List readCommand() {
        try {
            FileInputStream file = new FileInputStream("D:\\config\\config.txt");
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(file));
            ArrayList commands = (ArrayList) ois.readObject();
            ois.close();
            return commands;
        } catch (Exception e) {
            System.out.println("读取命令日志文件失败！");
            e.printStackTrace();
        }
        return null;
    }
}
