package com.person.cn.demotestone.annotation;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation
 * @updateUser
 * @date 16:292020/12/3
 */
@SuppressWarnings(value = "")
public class TestMyTag {
    @MyTag(name = "TestMyTag", age = 28)
    public void  test(){
    }

    public static void main(String[] args) {
        TestMyTag testMyTag = new TestMyTag();
        testMyTag.test();
    }
}
