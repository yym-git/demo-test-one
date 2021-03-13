package com.person.cn.demotestone.gc;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.gc
 * @updateUser
 * @date 10:25 2020/12/10
 */
public class FinalizeTest {
    private  static  FinalizeTest ft=null;
    public  void  info(){
        System.out.println("测试方法");
    }

    public static void main(String[] args) {
        new  FinalizeTest();
        System.gc();
        System.runFinalization();
        ft.info();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("重新引用");
        ft = this;
    }
}
