package com.person.cn.demotestone.iocom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 17:082020/12/4
 */
public class PushbackInputStreamTest {
    public static void main(String[] args) throws IOException {

        String str = "if ( a == 10) a =0;\n";
        byte[] byt = str.getBytes();
        int c;

        ByteArrayInputStream bais = new ByteArrayInputStream(byt);
        PushbackInputStream pbis = new PushbackInputStream(bais);
//        String str = "if ( a == 10) a = 0;\n";
        while ((c = pbis.read()) != -1) {
            switch (c) {
                case '=':
                    if ((c = pbis.read()) == '=') {
                        System.out.print(".equ.");
                    } else {
                        System.out.print("<-");
                        pbis.unread(c);
                    }
                    break;
                default:
                    System.out.print((char) c);
                    break;
            }
        }
    }
}
