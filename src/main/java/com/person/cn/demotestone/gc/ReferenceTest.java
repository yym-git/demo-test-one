package com.person.cn.demotestone.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 10:56 2020/12/10
 */
public class ReferenceTest {
    public static void main(String[] args) {
        String str  =new String("疯狂Java讲义");
        //弱引用
        System.out.println("=========弱引用测试============");
        WeakReference wr  = new WeakReference(str);
        //切断str变量与 "测试"字符串的引用关系
        str  = null;
        System.out.println("弱引用对象取值："+wr.get());
        System.gc();
        System.runFinalization();
        //再次取值
        System.out.println("gc后弱引用取值："+wr.get());

        System.out.println("================虚引用测试=============");
        String str2  =new String("疯狂Java讲义");
        ReferenceQueue rq = new ReferenceQueue();
        PhantomReference pf  = new PhantomReference(str2,rq);
        str2 = null;
        System.out.println("虚引用取值："+pf.get());
        System.gc();
        System.runFinalization();
        //垃圾回收之后虚引用会被放入到引用队列中
        System.out.println("比较："+(rq.poll() == pf));



    }
}
