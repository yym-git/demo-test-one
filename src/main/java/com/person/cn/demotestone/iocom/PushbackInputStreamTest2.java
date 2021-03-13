package com.person.cn.demotestone.iocom;

import java.io.FileReader;
import java.io.PushbackReader;

/**
 * @author ym.y
 * @description 字符推回流的使用
 * @package com.person.cn.demotestone.iocom
 * @updateUser
 * @date 16:282020/12/4
 */
public class PushbackInputStreamTest2 {
    public static void main(String[] args) {
        String dir  ="D:\\PersonDemon\\demo-test-one\\src\\main\\java\\com\\person\\cn\\demotestone\\" +
                "iocom\\PushbackInputStreamTest2.java";
        FileReader fr  =null;
        try{
            //创建一个文件输入流对象
            fr = new FileReader(dir);
            //创建推回输入流对象，并指定推回缓冲区的长度为64
            PushbackReader pr = new PushbackReader(fr,64);
            //每次读取的字符大小
            char[] buf = new  char[32];
            //保存上次读取的字符串内容
            String lastContent = "";
            //实际读取的字符串个数
            int hashRead = 0;
            while((hashRead = pr.read(buf))>0){
                String content  = new  String(buf,0,hashRead);
                int targetIndex = 0;
                //将上次读取的内容拼接上本次读取的内容
                //查看拼接后的内容是否包含"new PushbackReader"字符串
                if((targetIndex = (lastContent+content).indexOf("new PushbackReader"))>0){
                    //将本次和上次读取的内容回推到缓冲区中
                    //将字节数组的内容推回到缓冲区中
                    pr.unread((lastContent+content).toCharArray());
                    //上次和本次读取的字符串长度大于32，则重新定义一个长度为targetIndex的char数组
                    if(targetIndex > 32){
                        buf  =new  char[targetIndex];
                    }
                    //再次读取指定长度的内容
                    pr.read(buf,0,targetIndex);
                    //打印读取内容
                    System.out.println(new String(buf,0,targetIndex));
                    //0-正常退出程序
                    //1-非正常退出程序
                    System.exit(0);
                }else{
                    System.out.println("不包含目标内容开始");
                    //打印上次读取的内容
                    System.out.println("上次读取内容："+lastContent);
//                    System.exit(0);
                    //将本次读取内容设置为上次读取内容
                    lastContent = content;
                    System.out.println("不包含目标内容结束");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
