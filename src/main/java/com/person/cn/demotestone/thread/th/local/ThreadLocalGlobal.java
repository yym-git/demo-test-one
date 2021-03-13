package com.person.cn.demotestone.thread.th.local;

/**
 * @author ym.y
 * @description 当前用户需要被线程内的所有方法共享
 * 一个登录请求是一个线程，一个登录操作涉及到多个方法的处理，多个方法公用一个请求对象
 * @package com.person.cn.demotestone.thread.th.local
 * @updateUser
 * @date 11:40 2020/12/30
 */
public class ThreadLocalGlobal {
    public static void service1(){
        User user  = new  User("张三丰");
        UserUtils.user.set(user);
        System.out.println("方法一："+user.getName());
        service2();
    }

    public  static void  service2(){
        System.out.println("方法二："+UserUtils.user.get().getName());
        service3();
    }

    public  static void  service3(){
        System.out.println("方法二："+UserUtils.user.get().getName());
    }

    public static void main(String[] args) {
        service1();
    }
}

class User {
    private String name;
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class UserUtils{
    public  static  ThreadLocal<User> user = new ThreadLocal<>();
}
