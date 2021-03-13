package com.person.cn.demotestone.thread.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ym.y
 * @description ConcurrentHashmap的组合操作并不保证线程安全
 * @package com.person.cn.demotestone.thread.concurrentmap
 * @updateUser
 * @date 17:28 2020/12/31
 */
public class OptionsNotSafe implements Runnable {
    private static ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();

    @Override
    public void run() {
        safe();
    }

    /**
     * @description 组合操作线程不安全
     * @author ym.y
     * @updateUser
     * @date 17:37 2020/12/31
     */
    private void unSafe() {
        for (int i = 0; i < 1000; i++) {
            Integer score = scores.get("晓明");
            Integer newScore = score + 1;
            scores.put("晓明", newScore);
        }
    }

    /**
     * @description 线程安全的
     * @author ym.y
     * @updateUser
     * @date 17:42 2020/12/31
     */
    private void safe() {
        for (int i = 0; i < 1000; i++) {
            while (true) {
                Integer score = scores.get("晓明");
                Integer newScore = score + 1;
                boolean flag = scores.replace("晓明", score, newScore);
                if (flag) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        scores.put("晓明", 0);
        OptionsNotSafe unSafe = new OptionsNotSafe();
        Thread th1 = new Thread(unSafe);
        Thread th2 = new Thread(unSafe);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(scores);
    }
}
