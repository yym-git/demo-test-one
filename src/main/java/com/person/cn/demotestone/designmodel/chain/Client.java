package com.person.cn.demotestone.designmodel.chain;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.chain
 * @updateUser
 * @date 15:23 2020/12/15
 */
public class Client {
    public static void main(String[] args) {
        test2();
    }
    /**
     * @description  审批顺序为:主任->副董事长->董事长->董事会
     * @author ym.y
     * @updateUser
     * @date  15:43 2020/12/15
     */
    public static void test1(){
        Approver wjzhang, gyang, jguo, meeting;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        jguo = new President("郭靖");
        meeting = new Congress("董事会");
        wjzhang.setApprover(gyang);
        gyang.setApprover(jguo);
        jguo.setApprover(meeting);
        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        wjzhang.processResult(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买屠龙刀");
        gyang.processResult(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000, 10003, "购买《九阴真经》");
        jguo.processResult(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000, 10004, "购买桃花岛");
        meeting.processResult(pr4);
    }

    /**
     * @description  审批顺序为:主任->董事长->董事会
     * @author ym.y
     * @updateUser
     * @date  15:44 2020/12/15
     */
    public static void test2(){
        Approver wjzhang, gyang, jguo, meeting;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        jguo = new President("郭靖");
        meeting = new Congress("董事会");
        wjzhang.setApprover(jguo);
//        gyang.setApprover(jguo);
        jguo.setApprover(meeting);
        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        wjzhang.processResult(pr1);
//        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买屠龙刀");
//        gyang.processResult(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000, 10003, "购买《九阴真经》");
        jguo.processResult(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000, 10004, "购买桃花岛");
        meeting.processResult(pr4);
    }
}
