package com.person.cn.demotestone.thread.condition.test2;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.condition.test2
 * @updateUser
 * @date 14:43 2021/1/12
 */
public class Producer implements Runnable {
    private MyService myService;

    public Producer(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myService.put();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
