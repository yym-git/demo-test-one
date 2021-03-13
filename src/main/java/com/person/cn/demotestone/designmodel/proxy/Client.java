package com.person.cn.demotestone.designmodel.proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.proxy
 * @updateUser
 * @date 12:54 2020/12/15
 */
public class Client {
    public static void main(String[] args) {
        ProxySearcher proxy = new ProxySearcher();
        proxy.doSearch("yym","独孤九剑");
    }
}
