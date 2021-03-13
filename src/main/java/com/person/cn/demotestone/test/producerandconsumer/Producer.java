package com.person.cn.demotestone.test.producerandconsumer;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.test.producerandconsumer
 * @updateUser
 * @date 20:19 2021/1/12
 */
public class Producer implements Runnable {
    private MyService myService;

    public Producer(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i =0; i<20; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myService.put();
        }
    }
}
