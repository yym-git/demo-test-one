package com.person.cn.demotestone.designmodel.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description 周报-带附件（引用类型）
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 12:24 2020/12/12
 */
@Data
@Slf4j
public class WeekLog implements Cloneable {
    private String name;
    private String date;
    private String content;
    private Attachment attachment;

    @Override
    protected WeekLog clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            log.info("不支持复制");
            e.printStackTrace();
        }
        return (WeekLog)obj;
    }
}
