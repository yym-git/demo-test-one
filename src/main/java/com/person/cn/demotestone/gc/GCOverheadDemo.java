package com.person.cn.demotestone.gc;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 垃圾回收上头
 *
 * JVM参数配置：
 * -Xms10m -Xmx10m  -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * GC回收时间过长会抛出OutOfMemoryError。超过98%的时间用来GC并且回收了2%的堆内存
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 15:02 2021/3/1
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String>  list = new ArrayList<>();
        try {
            while(true){
                //intern()手动将字符串加入常量池
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("************** i:"+i);
            e.printStackTrace();
          throw e;
        }
    }
}
