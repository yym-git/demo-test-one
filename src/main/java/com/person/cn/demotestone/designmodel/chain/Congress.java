package com.person.cn.demotestone.designmodel.chain;

/**
 * @author ym.y
 * @description 董事会类：具体处理类
 * @package com.person.cn.demotestone.designmodel.chain
 * @updateUser
 * @date 15:20 2020/12/15
 */
public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }

    @Override
    public void processResult(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单：" + request.getNumber() + ",金额：" +
                request.getAmount() + "元，目的：" + request.getPurpose());
    }

}
