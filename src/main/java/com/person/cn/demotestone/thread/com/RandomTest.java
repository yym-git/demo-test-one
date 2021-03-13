package com.person.cn.demotestone.thread.com;

import java.util.Random;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 12:442020/11/17
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int  i =0; i < 10; ++i){
            System.out.println(random.nextInt(5));
        }
    }
}
