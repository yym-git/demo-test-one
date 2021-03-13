package com.person.cn.demotestone.designmodel.flyweight;

import lombok.Data;

/**
 * @author ym.y
 * @description 坐标类：外部类
 * @package com.person.cn.demotestone.designmodel.flyweight
 * @updateUser
 * @date 15:47 2020/12/18
 */
@Data
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
