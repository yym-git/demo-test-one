package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;

/**
 * @author ym.y
 * @description 具体DocumentDao类：真实角色
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 13:29 2020/12/15
 */
public class DocumentDao  implements  AbstractDocumentDao{

    @Override
    public Boolean deleteDocumentById(String documentId) {
        if("D001".equalsIgnoreCase(documentId)){
            System.out.println("查询ID为‘"+documentId+"’的信息成功！");
            return  true;
        }else{
            System.out.println("查询ID为‘"+documentId+"’的信息失败！");
            return  false;
        }
    }
}
