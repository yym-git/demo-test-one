package com.person.cn.demotestone.iocom.randomAccessFile;

import java.io.RandomAccessFile;

/**
 * @author ym.y 读写模式，给文件追加内容
 * @description
 * @package com.person.cn.demotestone.iocom.randomAccessFile
 * @updateUser
 * @date 13:392020/12/5
 */
public class RandomAccessFileTest2 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("D:\\test.txt","rw")){
            //将指针移动到文件的最后位置
            raf.seek(raf.length());
            raf.write("\n这是追加的内容\n".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
