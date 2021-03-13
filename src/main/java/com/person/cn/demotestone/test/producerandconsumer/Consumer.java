package com.person.cn.demotestone.test.producerandconsumer;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test.producerandconsumer
 * @updateUser
 * @date 20:20 2021/1/12
 */
public class Consumer implements Runnable {
    private MyService myService;

    public Consumer(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myService.get();
        }
    }
}
