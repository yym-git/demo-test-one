package com.person.cn.demotestone.designmodel.prototype.prototypemanager;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.prototype.prototypemanager
 * @updateUser
 * @date 15:05 2020/12/12
 */
public class Client {
    public static void main(String[] args) {
        //获取原型管理器对象
        PrototypeManager pm = PrototypeManager.getPrototypeManager();
        OfficialDocument doc1, doc2, doc3, doc4,doc5,doc6;
        doc1 = pm.getOfficialDocument("far");
        doc1.display();
        doc2 = pm.getOfficialDocument("far");
        doc2.display();
        System.out.println(doc1 == doc2);
        doc3 = pm.getOfficialDocument("srs");
        doc3.display();
        doc4 = pm.getOfficialDocument("srs");
        doc4.display();
        System.out.println(doc3 == doc4);
        System.out.println("============================");
        OfficialDocument ppr = new PPR();
        pm.addOfficialDocument("ppr",ppr);
        doc5 = pm.getOfficialDocument("ppr");
        doc6 = pm.getOfficialDocument("ppr");
        System.out.println(ppr==doc5);
        System.out.println(ppr==doc6);
        System.out.println(doc5==doc6);
        doc5.display();
        doc6.display();

    }
}
