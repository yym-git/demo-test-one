package com.person.cn.demotestone.thread.cache.person;

/**
 * @author ym.y
 * @description 耗时计算实现类,本身不具备缓存能力
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:53 2021/1/4
 */
public class ExpensiveFunction implements  Computable<String,Integer> {
    @Override
    public Integer compute(String s) throws Exception {
        System.out.println("开始计算");
        Thread.sleep(2000);
        return new Integer(s);
    }
}

