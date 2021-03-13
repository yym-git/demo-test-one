package com.person.cn.demotestone.thread.th.local;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description 存在线程安全问题
 * @package com.person.cn.demotestone.thread.th.local
 * @updateUser
 * @date 10:44 2020/12/30
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int  value  = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String dateStr = ThreadLocalTest.date(value);
                    System.out.println(dateStr);
                }
            });
        }
        executorService.shutdown();
    }

    public static String date(int seconds) {
        Date date = new Date(seconds * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return format.format(date);
    }

}
