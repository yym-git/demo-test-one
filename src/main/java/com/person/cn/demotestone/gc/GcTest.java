package com.person.cn.demotestone.gc;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 10:14 2020/12/10
 */
public class GcTest {
    public static void main(String[] args) {

        for(int i =0; i< 10; i++){
            new  GcTest();
            System.gc();
//            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在清理GcTest对象的资源.......");
    }
}
