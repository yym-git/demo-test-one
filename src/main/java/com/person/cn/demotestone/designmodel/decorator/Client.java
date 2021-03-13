package com.person.cn.demotestone.designmodel.decorator;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.decorator
 * @updateUser
 * @date 18:02 2020/12/13
 */
public class Client {
    public static void main(String[] args) {
        test2();
    }
    /**
     * @description   只有滚动条的窗体
     * @author ym.y
     * @updateUser
     * @date  18:17 2020/12/13
     */
    public static void test1(){
        Component component,componentSB;
        component = new WindowComponent();
        componentSB = new ScrollBarDecorator(component);
        componentSB.display();

    }


    /**
     * @description   既有滚动条，又有黑色边框的窗体
     * @author ym.y
     * @updateUser
     * @date  18:18 2020/12/13
     */
    public static void test2(){
        Component component,componentSB,componentBB;
        component = new WindowComponent();
        componentSB = new ScrollBarDecorator(component);
        componentBB = new BlackBorderDecorator(componentSB);
        componentBB.display();
    }
}
