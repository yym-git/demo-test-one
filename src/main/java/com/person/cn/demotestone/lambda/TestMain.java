package com.person.cn.demotestone.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 22:40 2021/3/16
 */
public class TestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("dd");
        list.stream().distinct().collect(Collectors.toList());
    }
}
