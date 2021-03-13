package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 17:34 2020/12/17
 */
public class Client {
    public static void main(String[] args) {
        test2();
    }

    /**
     * @description 原来的需求
     * @author ym.y
     * @updateUser
     * @date 19:09 2020/12/17
     */
    public static void test1() {
        //定义中介对象
        Mediator mediator = new ConcreteMediator();
        //定义组件对象
        ButtonComponent addBT = new ButtonComponent();
        ListComponent listCmp = new ListComponent();
        ComboBoxComponent cb = new ComboBoxComponent();
        TextBoxComponent txtCmp = new TextBoxComponent();
        addBT.setMediator(mediator);
        listCmp.setMediator(mediator);
        cb.setMediator(mediator);
        txtCmp.setMediator(mediator);
        addBT.change();
        //之所以要强转是因为属于运行时类型
        ((ConcreteMediator) mediator).addButton = addBT;
        ((ConcreteMediator) mediator).listCmp = listCmp;
        ((ConcreteMediator) mediator).txb = txtCmp;
        ((ConcreteMediator) mediator).cb = cb;
        //按钮组件发生改变->影响
        addBT.change();
        System.out.println("----------------------");
        listCmp.change();
    }

    /**
     * @description 新增功能：按钮变动是label标签也需要变更
     * 解决思路：新增子类中介者，新增组件
     * @author ym.y
     * @updateUser
     * @date 19:14 2020/12/17
     */
    public static void test2() {
        //定义中介对象
        SubConcreteMediator mediator = new SubConcreteMediator();
        //定义组件对象
        ButtonComponent addBT = new ButtonComponent();
        ListComponent listCmp = new ListComponent();
        ComboBoxComponent cb = new ComboBoxComponent();
        TextBoxComponent txtCmp = new TextBoxComponent();
        //新增加的组件
        Label label = new Label();

        addBT.setMediator(mediator);
        listCmp.setMediator(mediator);
        cb.setMediator(mediator);
        txtCmp.setMediator(mediator);
        //新增加的组件添加中介者
        label.setMediator(mediator);
        addBT.change();
        //之所以要强转是因为属于运行时类型
        mediator.addButton = addBT;
        mediator.listCmp = listCmp;
        mediator.txb = txtCmp;
        mediator.cb = cb;
        mediator.label = label;
        //按钮组件发生改变->影响
        addBT.change();
        System.out.println("----------------------");
        listCmp.change();
    }
}
