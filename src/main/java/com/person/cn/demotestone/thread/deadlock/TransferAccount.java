package com.person.cn.demotestone.thread.deadlock;

/**
 * @author ym.y
 * @description 模拟银行转账：会发生死锁
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 11:03 2020/12/29
 */
public class TransferAccount implements Runnable {
    private static Acct a = new Acct(500);
    private static Acct b = new Acct(500);
    int flag = 1;

    @Override
    public void run() {
        if (flag == 1) {
            transfer(a, b, 200);
        }
        if (flag == 0) {
            transfer(b, a, 200);
        }
    }

    //银行账户类
    static class Acct {
        int balance;

        public Acct(int balance) {
            this.balance = balance;
        }
    }

    //转账方法
    //线程1进来 from = a,获取a锁，休眠200毫秒，让出CPU资源，但仍然持有a锁
    //线程2进来 from = b,获取b锁，休眠200好眠，让出CPU资源，但仍然持有b锁，
    //此时线程1休眠结束，尝试获取b锁，而b锁被线程2持有，接着，线程2休眠结束，尝试获取a锁，
    //最终导致相互等待，形成死锁。
    public static void transfer(Acct from, Acct to, int amount) {
        synchronized (from) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败！");
                } else {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("转账成功" + amount + "元");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TransferAccount account1 = new TransferAccount();
        TransferAccount account2 = new TransferAccount();
        account1.flag = 1;
        account2.flag = 0;
        Thread th1 = new Thread(account1);
        Thread th2 = new Thread(account2);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("账户a的余额：" + a.balance);
        System.out.println("账户b的余额：" + b.balance);
    }
}
