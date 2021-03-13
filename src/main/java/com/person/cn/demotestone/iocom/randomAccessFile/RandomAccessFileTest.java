package com.person.cn.demotestone.iocom.randomAccessFile;

import java.io.RandomAccessFile;

/**
 * @author ym.y
 * @description 任意访问文件: 从指定位置读取文件内容
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 13:262020/12/5
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        String dir = "D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\iocom\\randomAccessFile\\" +
                "RandomAccessFileTest.java";
        try (RandomAccessFile raf = new RandomAccessFile(dir, "r")) {

            System.out.println("文件指针的初始位置：" + raf.getFilePointer());
            //将文件指针移动到300的位置
            raf.seek(200);
            System.out.println("移动后的开始位置：" + raf.getFilePointer());
            byte[] buf = new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(buf)) > 0) {
                System.out.println(new String(buf, 0, hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
