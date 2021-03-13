package com.person.cn.demotestone.bean;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.bean
 * @updateUser
 * @date 23:042020/10/28
 */
public class OldResultModel {
    private OldResult oldResult;
    private String type;

    public OldResult getOldResult() {
        return oldResult;
    }

    public void setOldResult(OldResult oldResult) {
        this.oldResult = oldResult;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OldResultModel{" +
                "oldResult=" + oldResult +
                ", type='" + type + '\'' +
                '}';
    }
}
