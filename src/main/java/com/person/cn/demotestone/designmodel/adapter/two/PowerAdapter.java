package com.person.cn.demotestone.designmodel.adapter.two;

/**
 * @author ym.y
 * @description 电流适配器
 * @package com.person.cn.demotestone.designmodel.adapter.two
 * @updateUser
 * @date 13:49 2020/12/24
 */
public class PowerAdapter {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    public int outputDC5V() {
        int adapterInput = ac220.outputAC220();
        int adapterOut = adapterInput / 44;
        System.out.println("使用PowerAdapter输入AC：" + adapterInput + "V,输出DC：" + adapterOut+"V");
        return adapterOut;
    }
}
