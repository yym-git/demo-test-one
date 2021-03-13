package com.person.cn.demotestone.designmodel.abstractfactory.interfaces;

/**
 * @author ym.y
 * @description 皮肤界面工厂接口：抽象工厂
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:16 2020/12/11
 */
public interface SkinFactory {
    public Button createButton();

    public TextField createTextField();

    public ComboBox createComboBox();
}
