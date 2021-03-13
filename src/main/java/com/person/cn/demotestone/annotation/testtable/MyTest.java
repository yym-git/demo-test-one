package com.person.cn.demotestone.annotation.testtable;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation
 * @updateUser
 * @date 16:482020/12/3
 */
public class MyTest {
    @TestTable
    public static void m1() {

    }

    public static void m2() {

    }

    @TestTable
    public static void m3() {
        throw new RuntimeException("Boom!");
    }

    public static void m4() {

    }

    @TestTable
    public static void m5() {

    }

    public static void m6() {

    }

    @TestTable
    public static void m7() {
        throw new  RuntimeException("Crash!");
    }

    public static void m8() {

    }

}
