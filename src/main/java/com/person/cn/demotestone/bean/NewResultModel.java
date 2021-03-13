package com.person.cn.demotestone.bean;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.bean
 * @updateUser
 * @date 23:042020/10/28
 */
public class NewResultModel {
    private NewResult newResult;
    private String oldResultDesc;

    public NewResult getNewResult() {
        return newResult;
    }

    public void setNewResult(NewResult newResult) {
        this.newResult = newResult;
    }

    public String getOldResultDesc() {
        return oldResultDesc;
    }

    public void setOldResultDesc(String oldResultDesc) {
        this.oldResultDesc = oldResultDesc;
    }

    @Override
    public String toString() {
        return "NewResultModel{" +
                "newResult=" + newResult +
                ", oldResultDesc='" + oldResultDesc + '\'' +
                '}';
    }
}
