package com.person.cn.demotestone.inclass;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.inclass
 * @updateUser
 * @date 13:552020/12/9
 */
public class ProcessArray {
    public void process(int[] target,Command command){
        for(int a  : target ){
            command.process(a);
        }
    }
}
