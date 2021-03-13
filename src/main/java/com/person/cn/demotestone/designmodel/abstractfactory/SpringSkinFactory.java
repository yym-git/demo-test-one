package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.Button;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.ComboBox;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.SkinFactory;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.TextField;

/**
 * @author ym.y
 * @description Spring皮肤工厂：具体工厂
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 19:19 2020/12/11
 */
public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
