package com.person.cn.demotestone.designmodel.prototype.prototypemanager;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.prototype.prototypemanager
 * @updateUser
 * @date 15:12 2020/12/12
 */
@Slf4j
public class PPR implements  OfficialDocument {
    @Override
    public OfficialDocument clone() {
        OfficialDocument ppr = null;
        try {
            ppr = (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return ppr;
    }

    @Override
    public void display() {
        log.info("《项目进展报告》");
    }
}
