package com.person.cn.demotestone.thread.th.local;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description 加锁解决线程安全问题
 * @package com.person.cn.demotestone.thread.th.local
 * @updateUser
 * @date 10:44 2020/12/30
 */
public class ThreadLocalTest3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        HashSet<String> sets = new HashSet<>();
        for (int i = 0; i < 2000; i++) {
            int value = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String dateStr = ThreadLocalTest3.date(value);
                    System.out.println(dateStr);
                    sets.add(dateStr);
                }
            });
        }
        executorService.shutdown();
        Thread.sleep(2000);
        System.out.println("对象：" + sets.size());
    }

    public static String date(int seconds) {
        //创建多个对象，消耗内存
        Date date = new Date(seconds * 1000);
        SimpleDateFormat format = SimpleDateFormatUtil.dateFormat.get();
        return format.format(date);
    }
}

//生成静态的SimpleDateFormat对象，避免了多次创建对象带来的消耗
class SimpleDateFormatUtil {
    public static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        }
    };
}
