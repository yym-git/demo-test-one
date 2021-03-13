package com.person.cn.demotestone.designmodel.prototype.prototypemanager;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description 可行性分析报告
 * @package com.person.cn.demotestone.designmodel.prototype.prototypemanager
 * @updateUser
 * @date 14:40 2020/12/12
 */
@Slf4j
public class FAR implements OfficialDocument {
    @Override
    public OfficialDocument clone() {
        OfficialDocument far = null;
        try {
            far = (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            log.info("不支持复制");
            e.printStackTrace();
        }
        return far;
    }

    @Override
    public void display() {
        log.info("《可行性分析报告》");
    }
}
