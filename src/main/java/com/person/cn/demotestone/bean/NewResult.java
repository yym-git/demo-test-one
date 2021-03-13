package com.person.cn.demotestone.bean;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.bean
 * @updateUser
 * @date 23:012020/10/28
 */
public class NewResult {
    private int newAge;
    private String newName;
    private String newSex;

    public int getNewAge() {
        return newAge;
    }

    public void setNewAge(int newAge) {
        this.newAge = newAge;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewSex() {
        return newSex;
    }

    public void setNewSex(String newSex) {
        this.newSex = newSex;
    }

    @Override
    public String toString() {
        return "NewResult{" +
                "newAge=" + newAge +
                ", newName='" + newName + '\'' +
                ", newSex='" + newSex + '\'' +
                '}';
    }
}
