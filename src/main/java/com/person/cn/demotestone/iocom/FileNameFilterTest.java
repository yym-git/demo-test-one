package com.person.cn.demotestone.iocom;

import java.io.File;

/**
 * @author ym.y
 * @description 文件过滤器
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 14:042020/12/4
 */
public class FileNameFilterTest {
    public static void main(String[] args) {
        File file  = new  File(".");
        //文件以".java"结尾，或者文件对应一个路径，则返回true
        String[] nameList = file.list((dir,name)->
            name.endsWith(".java")||new File(name).isDirectory());
        for(String name : nameList){
            System.out.println(name);
        }
    }
}
