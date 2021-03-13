package com.person.cn.demotestone.designmodel.mediator.one;


/**
 * @author ym.y
 * @description 具体中介类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:36 2020/12/17
 */

public class ConcreteMediator extends Mediator {
    public ButtonComponent addButton;
    public ListComponent listCmp;
    public ComboBoxComponent cb;
    public TextBoxComponent txb;

    /**
     * @description 封装同事对象之间的交互
     * @author ym.y
     * @updateUser
     * @date 17:39 2020/12/17
     */
    @Override
    public void componentChanged(Component component) {
        //按钮发生改变则，列表框、组合框、文本框都会发生改变
        if(component == addButton){
            System.out.println("--单击增加按钮--");
            listCmp.update();
            cb.update();
            txb.update();
        }
        //列表发生改变，则列表选择内容，文本框内容回发生改变
        else if(component == listCmp ){
            System.out.println("--从列表框中选择客户--");
            listCmp.select();
            txb.setText();
        }
        //组合框发生改变，则组合框和文本内容会发生改变
        else if(component == cb){
            System.out.println("--从组合框选择客户--");
            cb.update();
            txb.setText();
        }
    }
}
