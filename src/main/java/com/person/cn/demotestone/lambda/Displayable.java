package com.person.cn.demotestone.lambda;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.lambda
 * @updateUser
 * @date 16:51 2020/12/9
 */
@FunctionalInterface
public interface Displayable {
    void display();
    default  int add(int a,int b){
        return a+b;
    }
}
