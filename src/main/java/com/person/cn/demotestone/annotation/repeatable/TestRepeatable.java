package com.person.cn.demotestone.annotation.repeatable;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.annotation.repeatable
 * @updateUser
 * @date 12:342020/12/4
 */
@FKTags({@FKTag(name = "张三",age = 18),@FKTag(name = "李四",age =20 )})
public class TestRepeatable {
}
@FKTag(name = "哼哈",age = 12)
@FKTag(name = "雪琪",age = 20)
class TestRepeatable2{

}
