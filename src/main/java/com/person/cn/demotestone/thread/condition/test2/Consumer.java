package com.person.cn.demotestone.thread.condition.test2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition.test2
 * @updateUser
 * @date 14:44 2021/1/12
 */
public class Consumer implements Runnable {
    private MyService myService;

    public Consumer(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i =0; i<50; i++){
            myService.get();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
