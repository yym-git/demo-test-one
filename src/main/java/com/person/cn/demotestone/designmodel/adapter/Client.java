package com.person.cn.demotestone.designmodel.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.adapter
 * @updateUser
 * @date 12:47 2020/12/13
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        ScoreOperation operation = new OperationAdapter();
        int[] scores ={84,76,50,69,90,91,88,96};
        int[] result= operation.sort(scores);
        log.info("成绩排序结果:");
        for(int i : result){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("查找成绩90：");
        int score = operation.search(result,90);
        if(score == -1){
            System.out.println("没找到");
        }else{
            System.out.println("找到");
        }
    }
}
