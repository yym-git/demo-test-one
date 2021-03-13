package com.person.cn.demotestone.designmodel.chain;

/**
 * @author ym.y
 * @description 董事长类：具体处理者
 * @package com.person.cn.demotestone.designmodel.chain
 * @updateUser
 * @date 15:18 2020/12/15
 */
public class President extends Approver {
    public President(String name) {
        super(name);
    }

    @Override
    public void processResult(PurchaseRequest request) {
        if (request.getAmount() < 500000) {
            System.out.println("董事长" + this.name + "审批采购单：" + request.getNumber() + "," +
                    "金额：" + request.getAmount() + "元,目的：" + request.getPurpose());
        }else{
            //请求转发
            this.approver.processResult(request);
        }
    }
}
