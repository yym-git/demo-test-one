package com.person.cn.demotestone.iocom.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.nio
 * @updateUser
 * @date 11:312020/12/9
 */
public class CharSetTest {
    public static void main(String[] args) {
        //获取Java支持的所有字符集
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String str : map.keySet()) {
            System.out.println(map.get(str));
        }
        System.out.println("\n\n");
        System.out.println("默认字符集："+Charset.defaultCharset());
    }
}
