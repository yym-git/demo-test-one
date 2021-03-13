package com.person.cn.demotestone.annotation.actionListenerFor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ym.y
 * @description 测试注解
 * @package com.person.cn.demotestone.annotation.actionListenerFor
 * @updateUser
 * @date 17:282020/12/3
 */
public class ActionListenerForTest {

    private JFrame mainWin  = new JFrame("使用注解绑定监听器");
    //为ok按钮绑定监听器
    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");
    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("取消");
    public void  init(){
        JPanel jp = new JPanel();
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);
        ActionListenerForProcess.processAnnotation(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }
    public static void main(String[] args) {
        new ActionListenerForTest().init();
    }

    /**
     * @description   定义ok按钮的事件监听器
     * @author ym.y
     * @updateUser
     * @date  17:53 2020/12/3
     */
    class OkListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"单击了确定按钮");
        }
    }

    /**
     * @description  定义cancel按钮的事件监听器
     * @author ym.y
     * @updateUser
     * @date  17:54 2020/12/3
     */
    class CancelListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"单击了取消按钮");
        }
    }
}
