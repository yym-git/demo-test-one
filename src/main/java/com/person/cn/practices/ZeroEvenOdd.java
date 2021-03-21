package com.person.cn.practices;

import java.util.concurrent.Semaphore;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices
 * @updateUser
 * @date 16:20 2021/3/21
 */
public class ZeroEvenOdd {
    private int n;
    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero() throws InterruptedException {
        for(int i=1; i<=n; i++){
            zero.acquire();
            IntConsumer.accept(0);
            if(i%2 == 1){
                odd.release();
            }else{
                even.release();
            }
        }
    }

    public void even() throws InterruptedException {
        for(int i=2; i<=n; i+=2){
            even.acquire();
            IntConsumer.accept(i);
            zero.release();
        }
    }

    public void odd() throws InterruptedException {
        for(int i=1; i<=n; i+=2){
            odd.acquire();
            IntConsumer.accept(i);
            zero.release();
        }
    }
}
