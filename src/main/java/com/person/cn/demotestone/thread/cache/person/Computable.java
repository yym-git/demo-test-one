package com.person.cn.demotestone.thread.cache.person;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.cache.person
 * @updateUser
 * @date 14:48 2021/1/4
 */
public interface Computable<K, V> {
    V compute(K k) throws Exception;
}
