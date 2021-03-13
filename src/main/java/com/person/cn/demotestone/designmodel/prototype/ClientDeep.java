package com.person.cn.demotestone.designmodel.prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description 深度克隆客户端
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 14:02 2020/12/12
 */
@Slf4j
public class ClientDeep {
    public static void main(String[] args) throws Exception {
        WeekLogDeepClone weekLogDeep = new WeekLogDeepClone();
        weekLogDeep.setDate("12");
        weekLogDeep.setContent("测试");
        Attachment attachment = new Attachment();
        attachment.setName("深度克隆");
        weekLogDeep.setAttachment(attachment);
        WeekLogDeepClone weekLogNew = weekLogDeep.deepClone();
        log.info("周报对象是否相同：" + (weekLogDeep == weekLogNew));
        log.info("附件是否相同：" + (weekLogDeep.getAttachment() == weekLogNew.getAttachment()));
    }
}
