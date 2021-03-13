package com.person.cn.demotestone.designmodel.proxy;

/**
 * @author ym.y
 * @description 具体查询类：真实主题类
 * @package com.person.cn.demotestone.designmodel.proxy
 * @updateUser
 * @date 12:46 2020/12/15
 */
public class RealSearcher implements Searcher {
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println("用户‘" + userId + "’使用关键字‘" + keyword + "’武林秘籍！");
        return "商务信息";
    }
}
