package com.person.cn.demotestone.thread.flowcontroller;

import lombok.Getter;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread.flowcontroller
 * @updateUser
 * @date 14:25 2021/2/26
 */
public enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "韩"), FIVE(5, "赵"), SIX(6, "魏");
    @Getter
    private Integer code;
    @Getter
    private String desc;

    private CountryEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CountryEnum forEach(Integer code) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if (code == countryEnum.getCode()) {
                return countryEnum;
            }
        }
        return null;
    }
}
