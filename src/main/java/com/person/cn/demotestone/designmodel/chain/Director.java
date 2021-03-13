package com.person.cn.demotestone.designmodel.chain;

/**
 * @author ym.y
 * @description 主任类：具体的处理者
 * @package com.person.cn.demotestone.designmodel.chain
 * @updateUser
 * @date 15:10 2020/12/15
 */
public class Director extends Approver {
    public Director(String name) {
        super(name);
    }

    /**
     * @description 具体请求处理方法
     * @author ym.y
     * @updateUser
     * @date 15:12 2020/12/15
     */
    @Override
    public void processResult(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            System.out.println("主任" + this.name + "审批采购单：" + request.getNumber() + "," +
                    "金额：" + request.getAmount() + "元,目的：" + request.getPurpose());
        }else{
            //请求转发
            this.approver.processResult(request);
        }
    }
}
