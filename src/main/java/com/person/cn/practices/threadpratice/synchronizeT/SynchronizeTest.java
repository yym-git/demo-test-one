package com.person.cn.practices.threadpratice.synchronizeT;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.practices.threadpratice.synchronizeT
 * @updateUser
 * @date 22:12 2021/3/20
 */
public class SynchronizeTest {
    private  int  value;
    public void getValue(){
        System.out.println(Thread.currentThread().getName()+"\t获取值：\t"+value);
    }
    public synchronized  void  setValue(){
        System.out.println(Thread.currentThread().getName()+"\t设值：\t"+(++value));
    }

    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();
        for(int i=0; i<5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronizeTest.setValue();
                }
            }).start();
        }

        for(int i=0; i<5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronizeTest.getValue();
                }
            }).start();
        }
    }
}
