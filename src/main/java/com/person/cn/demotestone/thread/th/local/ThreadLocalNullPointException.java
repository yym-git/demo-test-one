package com.person.cn.demotestone.thread.th.local;

/**
 * @author ym.y
 * @description ThreadLocal空指针异常
 * @package com.person.cn.demotestone.thread.th.local
 * @updateUser
 * @date 12:57 2020/12/30
 */
public class ThreadLocalNullPointException {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    public  void  set(){
        System.out.println("线程id："+Thread.currentThread().getId());
        longThreadLocal.set(Thread.currentThread().getId());
    }

    /**
     * @description  如果返回类型为long，并且并没有设置值时，会报空指针异常
     * 返回类型为Long时，且没有设置，返回null
     * @author ym.y
     * @updateUser
     * @date  13:10 2020/12/30
     */
    public  Long  get(){
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNullPointException nullPointException = new ThreadLocalNullPointException();
        System.out.println(nullPointException.get());
        nullPointException.set();
        System.out.println(nullPointException.get());
    }
}
