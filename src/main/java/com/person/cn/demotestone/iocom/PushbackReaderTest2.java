package com.person.cn.demotestone.iocom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 10:302020/12/5
 */
public class PushbackReaderTest2 {
    public static void main(String[] args) throws Exception {
        String  str  ="abc";
        ByteArrayInputStream bys = new ByteArrayInputStream(str.getBytes());
        PushbackInputStream ps  = new PushbackInputStream(bys);
        int c = 0;
        int count  = 0;
        while((c=ps.read())!=-1){
            if((ps.read()) == 'b'){
                ps.unread(c);
            }
            count++;
            System.out.println("=====");
        }
        System.out.println("循环次数:"+count);
    }
}
