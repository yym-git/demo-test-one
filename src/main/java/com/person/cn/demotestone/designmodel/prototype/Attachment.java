package com.person.cn.demotestone.designmodel.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author ym.y
 * @description 文件附件
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 13:22 2020/12/12
 */
@Slf4j
@Data
public class Attachment  implements Serializable {
    private  String name;
    public void  download(){
     log.info("下载附件，文件名为："+name);
    }
}
