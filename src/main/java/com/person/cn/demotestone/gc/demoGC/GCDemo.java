package com.person.cn.demotestone.gc.demoGC;

import java.util.Random;

/**
 * @author ym.y
 * @description 演示7大垃圾收集器
 * 1、serialGC(串行收集器)
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC  新生代和老年代使用串行收集器
 *
 * 2、ParNew(并行收集器)
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags  -XX:+UseParNewGC 新生代使用并行回收，老年代使用串行回收
 * -XX:ParallelGCThreads  限制线程数量，默认开启和CPU相同的线程数
 *
 * 3、ParallelGC（并行收集器）
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC 新生代和老年代都使用并行收集器
 *
 * 4、ParallelOldGC（老年代并行垃圾收集器）
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC
 *
 * 5、CMS（并发标记清除垃圾收集器）--发生在老年代
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 *
 * 6、SerialOld（老年代串行收集器-理论即可，实际中被java8优化）
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 *
 * 7、G1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 22:14 2021/3/1
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("***************GC  Hello****************");
        try {
            String str ="yym";
            while(true){
                str+=str+new GCDemo()+new Random().nextInt(10000000)+"ddd"+new Random().nextInt(99999999);
                //手动将字符串加入常量池
                str.intern();
            }
        } catch (Throwable e) {
        }
    }
}
