package com.person.cn.demotestone.iocom.nio;

import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.nio
 * @updateUser
 * @date 14:522020/12/8
 */
public class BufferTest {
    public static void main(String[] args) {
        CharBuffer buff  = CharBuffer.allocate(8);
        System.out.println("capacity:"+buff.capacity());
        System.out.println("limit:"+buff.limit());
        System.out.println("position:"+buff.position());
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("添加3个元素后position："+buff.position());
        System.out.println("添加3个元素后，limit："+buff.limit());
        //将limit = position 并且 position = 0
        buff.flip();
        System.out.println("执行flip方法后，limit："+buff.limit());
        System.out.println("执行flip方法后，position："+buff.position());
        //取出第一个元素
        System.out.println("第一个元素(position=0)："+buff.get());
        System.out.println("取出第一个元素后，position:"+buff.position());
        //调用clear
        buff.clear();
        System.out.println("执行clear方法后,limit："+buff.limit());
        System.out.println("position："+buff.position());
        System.out.println("执行clear后，缓冲区的内容并没有被清除，第3个元素："+buff.get(2));
        System.out.println("执行绝对读取后："+buff.position());
    }
}
