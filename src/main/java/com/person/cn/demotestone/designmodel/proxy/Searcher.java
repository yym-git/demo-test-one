package com.person.cn.demotestone.designmodel.proxy;

/**
 * @author ym.y
 * @description 抽象查询类：抽象主题类
 * @package com.person.cn.demotestone.designmodel.proxy
 * @updateUser
 * @date 12:36 2020/12/15
 */
public interface Searcher {
    public String doSearch(String userId,String keyword);
}
