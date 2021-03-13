package com.person.cn.demotestone.designmodel.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import sun.awt.image.ByteInterleavedRaster;

import java.io.*;

/**
 * @author ym.y
 * @description 深度克隆
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 13:55 2020/12/12
 */
@Data
@Slf4j
public class WeekLogDeepClone implements  Serializable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    /**
     * @description 实现深度克隆的方法
     * @author ym.y
     * @updateUser
     * @date 13:57 2020/12/12
     */
    public WeekLogDeepClone deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeekLogDeepClone) ois.readObject();

    }
}
