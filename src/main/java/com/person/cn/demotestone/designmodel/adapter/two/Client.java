package com.person.cn.demotestone.designmodel.adapter.two;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.adapter.two
 * @updateUser
 * @date 13:53 2020/12/24
 */
public class Client {
    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter(new AC220());
        System.out.println("返回结果：" + powerAdapter.outputDC5V()+"V");
    }
}
