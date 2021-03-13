package com.person.cn.demotestone.test;

import java.io.Serializable;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test
 * @updateUser
 * @date 16:24 2020/12/23
 */
public class LazySimpleSingleton  implements Serializable {
    private  LazySimpleSingleton(){}
    private  static  LazySimpleSingleton lazy = null;
    public   static  LazySimpleSingleton getInstance(){
        if(lazy == null ){
            synchronized (LazySimpleSingleton.class){
                lazy = new LazySimpleSingleton();
            }
        }
        return  lazy;
    }

    /**
     * @description  防止反序列化破坏单例
     * @author ym.y
     * @updateUser
     * @date  17:20 2020/12/23
     */
    private  Object  readResolve(){
        return lazy;
    }
}
