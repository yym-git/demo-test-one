package com.person.cn.demotestone.designmodel.mediator.one;

/**
 * @author ym.y
 * @description 新增中介者类
 * @package com.person.cn.demotestone.designmodel.mediator.one
 * @updateUser
 * @date 19:06 2020/12/17
 */
public class SubConcreteMediator extends ConcreteMediator {
    public Label label;
    /**
     * @description 封装同事对象之间的交互
     * @author ym.y
     * @updateUser
     * @date 17:39 2020/12/17
     */
    @Override
    public void componentChanged(Component component) {
        //按钮发生改变则，列表框、组合框、文本框都会发生改变
        //新增加的内容：文本标签也需要发生改变
        if(component == addButton){
            System.out.println("--单击增加按钮--");
            listCmp.update();
            cb.update();
            txb.update();
            label.update();
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
