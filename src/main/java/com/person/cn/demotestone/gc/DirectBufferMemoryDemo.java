package com.person.cn.demotestone.gc;

import java.nio.ByteBuffer;

/**
 * @author ym.y
 * @description  异常类型 ： java.lang.OutOfMemoryError: Direct buffer memory
 * ByteBuffer.allocate():  分配堆内存，属于GC管理，需要拷贝，速度慢
 * ByteBuffer.allocateDirect()：分配OS本地内存，不属于GC管理，不需要内存拷贝，速度快
 * 不使用堆内存，不要GC处理，对象不会被回收，堆内存充足，但是本地内存使用完时，再次分配本地内存会导致内存溢出
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 15:30 2021/3/1
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("查看配置的最大直接内存MaxDirectMemory："
                +(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // -XX:MaxDirectMemorySize=5m 配置5m，实际使用6M
        ByteBuffer buf  = ByteBuffer.allocateDirect(6*1024*1024);
    }
}
