package com.person.cn.demotestone.thread.condition;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 14:11 2021/1/12
 */
public class MyThreadA implements Runnable{
    private MyService myService;

    public MyThreadA(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run(){
        for (int i = 0 ; i < 10 ; i++){
            myService.set();
        }
    }
}

