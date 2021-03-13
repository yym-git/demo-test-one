package com.person.cn.demotestone.designmodel.chain;

import lombok.Data;

/**
 * @author ym.y
 * @description 采购单：请求类
 * @package com.person.cn.demotestone.designmodel.chain
 * @updateUser
 * @date 15:02 2020/12/15
 */
@Data
public class PurchaseRequest {
    private double amount;
    private int number;
    private String purpose;

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }
}
