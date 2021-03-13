package com.person.cn.demotestone.iocom.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.nio
 * @updateUser
 * @date 11:04 2021/1/6
 */
public class FileChannelTest2 {
    public static void main(String[] args) throws IOException {
        String dir = "D:\\encrypt.txt";
        RandomAccessFile aFile = new RandomAccessFile(dir, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(32);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println(" Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
