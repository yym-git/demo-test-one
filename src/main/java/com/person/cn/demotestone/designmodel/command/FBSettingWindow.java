package com.person.cn.demotestone.designmodel.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description 功能键设置窗口
 * @package com.person.cn.demotestone.designmodel.command
 * @updateUser
 * @date 16:55 2020/12/15
 */
public class FBSettingWindow {
    //窗口标题
    private String title;
    //定义一个集合存储所有的功能键
    private List<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }


    /**
     * @description 添加功能键
     * @author ym.y
     * @updateUser
     * @date 16:59 2020/12/15
     */
    public void addFunctionButton(FunctionButton fb) {
        functionButtons.add(fb);
    }

    /**
     * @description 移除功能键
     * @author ym.y
     * @updateUser
     * @date 17:00 2020/12/15
     */
    public void removeFunctionButton(FunctionButton fb) {
        functionButtons.remove(fb);
    }

    /**
     * @description 显示窗口及功能
     * @author ym.y
     * @updateUser
     * @date  17:01 2020/12/15
     */
    public void display(){
        System.out.println("显示窗口："+this.title);
        System.out.println("显示功能键：");
        for(FunctionButton fb : functionButtons){
            System.out.println(fb.getName());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
