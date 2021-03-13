package com.person.cn.demotestone.iocom.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.nio
 * @updateUser
 * @date 15:502020/12/8
 */
public class FileChannelTest {
    public static void main(String[] args) {
        String path = "D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\iocom\\nio\\FileChannelTest.java";
        File f = new File(path);
        try (FileChannel fileInChannel = new FileInputStream(f).getChannel();
             FileChannel fileOutChannel =new FileOutputStream("D:\\a.txt").getChannel();
        ) {
            //将FileChannel中的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = fileInChannel.map(FileChannel.MapMode.READ_ONLY,0,f.length());
            //直接将Buffer中的数据全部输出
            fileOutChannel.write(buffer);
            //调用clear方法复limit和position的位置
//            buffer.clear();
            System.out.println("limit:"+buffer.limit());
            System.out.println("position:"+buffer.position());
            System.out.println("clear==================");
            buffer.clear();
            System.out.println("limit:"+buffer.limit());
            System.out.println("position:"+buffer.position()+"\n\n");
            //使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("UTF-8");
            //创建解码器--
            CharsetDecoder decoder = charset.newDecoder();
            //使用解码器将ByteBuffer转换成CharBuffer：字节流转字符流
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
