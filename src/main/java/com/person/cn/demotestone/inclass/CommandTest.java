package com.person.cn.demotestone.inclass;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.inclass
 * @updateUser
 * @date 13:592020/12/9
 */
public class CommandTest {
    public static void main(String[] args) {
        int[] array =new int[]{1,2,2,2};
        ProcessArray ps = new ProcessArray();
       /* ps.process(array, new Command() {
            @Override
            public void process(int element) {
                System.out.println("数组元素的平方是："+element*element);
            }
        });*/

       ps.process(array,(element)->{
           System.out.println("数组元素的平方是："+element*element);
       });
    }
}
