package com.person.cn.demotestone.designmodel.abstractfactory;

import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.Button;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.ComboBox;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.SkinFactory;
import com.person.cn.demotestone.designmodel.abstractfactory.interfaces.TextField;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.abstractfactory
 * @updateUser
 * @date 11:28 2020/12/12
 */
public class Client {
    public static void main(String[] args) {
        SkinFactory skinFactory = new SpringSkinFactory();
        Button springButton  = skinFactory.createButton();
        TextField springTextField = skinFactory.createTextField();
        ComboBox springComboBox = skinFactory.createComboBox();
        springButton.display();
        springTextField.display();
        springComboBox.display();

    }
}
