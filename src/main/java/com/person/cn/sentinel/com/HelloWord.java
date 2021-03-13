package com.person.cn.sentinel.com;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.sentinel.com
 * @updateUser
 * @date 16:41 2021/1/12
 */
public class HelloWord {
    public static void main(String[] args) {
        initFlowRules();
        while(true){
          Entry entry=null;
            try {
                entry = SphU.entry("HelloWord");
                //业务开始时间
                System.out.println("=====");
                System.out.println("=====");
                System.out.println("=====");
                Thread.sleep(20);

            } catch (BlockException | InterruptedException e) {
                System.out.println("访问资源被限制");
            }finally {
                if(entry != null){
                    entry.exit();
                }
            }
        }
    }
    /**
     * @description   流控规则
     * @author ym.y
     * @updateUser
     * @date  16:58 2021/1/12
     */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule =new FlowRule();
        rule.setResource("HelloWord");
        //设置QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒处理20个请求
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
