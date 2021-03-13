package com.person.cn.demotestone.iocom;

import java.io.FileWriter;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 15:052020/12/4
 */
public class FileWriterTest {
    public static void main(String[] args)  throws Exception{
        FileWriter fw = new FileWriter("D:\\pom.txt");
        fw.write("\t\t锦瑟--李商隐\n");
        fw.write("锦瑟无端五十弦,一弦一柱思华年。\n");
        fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\n");
        fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\n");
        fw.write("此情可待成追忆，只是当时已惘然。\n");
        fw.close();
    }
}
