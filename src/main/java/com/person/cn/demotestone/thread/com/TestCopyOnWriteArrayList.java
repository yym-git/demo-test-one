package com.person.cn.demotestone.thread.com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 16:162020/11/17
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("ds");
        System.out.println(list.remove(1));
    }
}
