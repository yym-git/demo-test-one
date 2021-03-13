package com.person.cn.demotestone.thread.deadlock;

import java.util.Random;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.deadlock
 * @updateUser
 * @date 10:07 2020/12/29
 */
public class MultiTransferMoney {
    //账户个数
    private static final int NUM_ACCOUNT = 20;
    //账户金额
    private static final int NUM_MONEY = 1000;
    //转账次数
    private static final int NUM_TRANSFER = 1000000;
    //线程数
    private static final int THREAD_NUM = 20;

    public static void main(String[] args) {
        Random random = new Random();
        TransferMoney.Account[] accounts = new TransferMoney.Account[NUM_ACCOUNT];
        for (int i = 0; i < NUM_ACCOUNT; i++) {
            accounts[i] = new TransferMoney.Account(NUM_MONEY);
        }

        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_TRANSFER; i++) {
                    int fromAcct = random.nextInt(NUM_ACCOUNT);
                    int toAcct = random.nextInt(NUM_ACCOUNT);
                    int amount = random.nextInt(NUM_MONEY);
                    TransferMoney.transferMoney(accounts[fromAcct], accounts[toAcct], amount);
                }
                System.out.println("程序运行结束！");
            }
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            new  TransferThread().start();
        }
    }
}
