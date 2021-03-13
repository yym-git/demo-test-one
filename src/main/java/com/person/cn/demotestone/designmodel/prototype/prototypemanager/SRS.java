package com.person.cn.demotestone.designmodel.prototype.prototypemanager;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.prototype.prototypemanager
 * @updateUser
 * @date 14:43 2020/12/12
 */
@Slf4j
public class SRS implements  OfficialDocument {
    @Override
    public OfficialDocument clone() {
        OfficialDocument srs = null;
        try {
           srs = (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return srs;
    }

    @Override
    public void display() {
        log.info("《软件需求规格说明书》");
    }
}
