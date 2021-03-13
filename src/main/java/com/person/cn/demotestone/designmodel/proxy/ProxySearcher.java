package com.person.cn.demotestone.designmodel.proxy;

/**
 * @author ym.y
 * @description 代理查询类：代理主题类
 * @package com.person.cn.demotestone.designmodel.proxy
 * @updateUser
 * @date 12:45 2020/12/15
 */
public class ProxySearcher implements Searcher {
    //维持一个对真实主题的引用
    private Searcher searcher = new RealSearcher();
    private AccessValidator validator;
    private Logger logger;

    @Override
    public String doSearch(String userId, String keyword) {
        if (validate(userId)) {
            //进行业务操作
            String result = searcher.doSearch(userId, keyword);
            this.log(userId);
            return result;
        }
        return null;
    }
    public boolean validate(String userId) {
        validator = new AccessValidator();
        return validator.validate(userId);
    }
    public void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }
}
