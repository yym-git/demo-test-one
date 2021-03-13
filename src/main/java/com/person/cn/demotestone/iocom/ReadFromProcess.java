package com.person.cn.demotestone.iocom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 10:572020/12/5
 */
public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("javac");
        BufferedReader br  = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String buff = null;
        while((buff = br.readLine())!= null){
            System.out.println(buff);
        }
    }
}
