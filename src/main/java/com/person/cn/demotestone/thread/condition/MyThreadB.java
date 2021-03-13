package com.person.cn.demotestone.thread.condition;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition
 * @updateUser
 * @date 14:12 2021/1/12
 */
public class MyThreadB implements  Runnable {
    private MyService myService;

    public MyThreadB(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run(){
        for (int i = 0 ; i < 10 ; i++){
            myService.get();
        }
    }
}
