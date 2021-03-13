package com.person.cn.demotestone.designmodel.chain;

/**
 * @author ym.y
 * @description 审批者类：抽象处理类
 * @package com.person.cn.demotestone.designmodel.chain
 * @updateUser
 * @date 15:05 2020/12/15
 */
public abstract class Approver {
    //定义后继对象
    protected Approver approver;
    //审批者名字
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    //设置后继者
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //抽象请求处理方法
    public abstract void processResult(PurchaseRequest request);
}
