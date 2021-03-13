package com.person.cn.demotestone.designmodel.flyweight;

/**
 * @author ym.y
 * @description 白色棋子：具体享元类
 * @package com.person.cn.demotestone.designmodel.flyweight.one
 * @updateUser
 * @date 15:20 2020/12/18
 */
public class WhiteIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "白色";
    }
}
