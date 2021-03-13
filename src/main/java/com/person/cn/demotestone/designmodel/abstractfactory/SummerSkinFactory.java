package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.Button;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.ComboBox;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.SkinFactory;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.TextField;

/**
 * @author ym.y
 * @description Summer皮肤工厂：具体的工厂
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:20 2020/12/11
 */
public class SummerSkinFactory  implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
