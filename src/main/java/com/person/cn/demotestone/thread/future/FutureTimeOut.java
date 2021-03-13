package com.person.cn.demotestone.thread.future;

import java.util.concurrent.*;

/**
 * @author ym.y
 * @description 演示get()的超时方法，需要注意超时后的处理，future.cancel().该方法需要传入一个boolean参数
 * @package com.person.cn.demotestone.thread.future
 * @updateUser
 * @date 15:32 2021/1/3
 */
public class FutureTimeOut {
    private static ExecutorService exec = Executors.newFixedThreadPool(10);

    static class Ad {
        private String name;

        public Ad(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Add{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class FetchTask implements Callable {
        @Override
        public Ad call() throws Exception {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("sleep期间被中断了");
                return new Ad("被中断时的默认广告");
            }
            return new Ad("旅游订票哪家强?");
        }
    }

    public void printAd() {
        Future<Ad> f = exec.submit(new FetchTask());
        Ad ad;
        try {
            ad = f.get(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            ad = new Ad("被中断时的默认广告！");
        } catch (ExecutionException e) {
            ad = new Ad("异常时的默认广告！");
        } catch (TimeoutException e) {
            ad = new Ad("超时的默认广告！");
            System.out.println("超时未获取到广告！");
            //取消线程
            //传入false时， call()方法会正常执行完
            boolean flag = f.cancel(true);
            System.out.println("取消的结果：" + flag);
        }
        exec.shutdown();
        System.out.println("最终返回结果：" + ad);
    }

    public static void main(String[] args) {
        FutureTimeOut timeOut = new FutureTimeOut();
        timeOut.printAd();
    }
}
