package com.person.cn.demotestone.thread.deadlock;

/**
 * @author ym.y
 * @description 模拟多用户相互转账
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 9:21 2020/12/29
 */
public class TransferMoney implements Runnable {
    int flag = 1;
    static Account a = new Account(500);
    static Account b = new Account(500);
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r2);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("a的余额：" + a.balance);
        System.out.println("b的余额：" + b.balance);
    }

    @Override
    public void run() {
        if (flag == 0) {
            System.out.println("============");
            transferMoney(a, b, 200);
        }
        if (flag == 1) {
            System.out.println("-------");
            transferMoney(b, a, 200);
        }
    }

    public static void transferMoney(Account from, Account to, int amount) {
        class Helper {
            public void transfer() {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败！");
                } else {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println(Thread.currentThread().getName() + "成功转账" + amount + "元");
                }
            }
        }

        //实际场景中可以使用业务主键来比较
        //线程1 a->b 即from = a
        //线程2 b->a 即from = b
        //假设a的hash值>b的hash值
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    new Helper().transfer();
                }
            }
        } else {
            //如果相同，用新的锁
            synchronized (obj) {
                synchronized (to) {
                    synchronized (from) {
                        new Helper().transfer();
                    }
                }
            }

        }
      /*  synchronized (from) {
            System.out.println(Thread.currentThread().getName() + "获取到了from锁");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + "获取到了to锁");
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败！");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println(Thread.currentThread().getName() + "成功转账" + amount + "元");
            }
        }*/
    }

    static class Account {
        private int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }
}
