package com.person.cn.demotestone.designmodel.prototype.prototypemanager;

import java.util.Hashtable;

/**
 * @author ym.y
 * @description 原型管理器:将多个原型对象存储在一个集合中供客户端使用，是一个专门负责克隆对象的工厂，
 * 其中定义了一个集合用于存储原型对象，如果需要某个原型对象的克隆，可以通过复制集合中对应的原型对象来获取。
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 14:36 2020/12/12
 */
public class PrototypeManager {
    private Hashtable<String, OfficialDocument> ht = new Hashtable();

    private PrototypeManager() {
        ht.put("far", new FAR());
        ht.put("srs", new SRS());
    }

    /**
     * @description 增加新的公文对象
     * @author ym.y
     * @updateUser
     * @date 15:00 2020/12/12
     */
    public void addOfficialDocument(String key, OfficialDocument doc) {
        ht.put(key, doc);
    }

    /**
     * @description 获取原型管理器
     * @author ym.y
     * @updateUser
     * @date 14:59 2020/12/12
     */
    public static PrototypeManager getPrototypeManager() {
        PrototypeManager pm = new PrototypeManager();
        return pm;
    }

    /**
     * @description 通过浅克隆获取新的公文对象
     * @author ym.y
     * @updateUser
     * @date 15:01 2020/12/12
     */
    public OfficialDocument getOfficialDocument(String key) {
        return ht.get(key).clone();
    }
}

