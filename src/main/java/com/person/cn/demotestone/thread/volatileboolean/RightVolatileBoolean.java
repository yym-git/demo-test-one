package com.person.cn.demotestone.thread.volatileboolean;

/**
 * @author ym.y
 * @description volatile boolean的可行情况
 * @package com.person.cn.demotestone.thread.volatilecom
 * @updateUser
 * @date 17:12 2020/12/25
 */
public class RightVolatileBoolean implements Runnable {
    private static volatile boolean flag = false;

    @Override
    public void run() {
        int a = 0;
        try {
            while (a <= 200000 && !flag) {
                if (a % 2 == 0) {
                    System.out.println(a + "是5的倍数");
                }
                a++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightVolatileBoolean());
        thread.start();
        Thread.sleep(3000);
        flag = true;
    }
}
